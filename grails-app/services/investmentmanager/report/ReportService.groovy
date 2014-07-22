package investmentmanager.report

import grails.transaction.Transactional
import investmentmanager.asset.Asset
import investmentmanager.asset.Company
import investmentmanager.asset.Stock
import investmentmanager.forecast.Forecast
import investmentmanager.forecast.Investment
import investmentmanager.report.OverallReport
import investmentmanager.report.Summary
import java.text.NumberFormat

import calculator.FinancialCalculator
import json.GoogleFinanceJSON
import xml.TreasuryXML
import proxy.authentication

@Transactional
class ReportService {
    def grailsApplication
      
    def populateForecasts(forecastRanking,list,report){
         for(int i = 0; i < Integer.parseInt(grailsApplication.config.grails.data.forecast.items); i++ ){
            def forecast = new Forecast()
            forecast.ranking = forecastRanking
            forecastRanking++
            forecast.asset = list.get(i)
            int investmentRanking = 0
            for(int j = 0; j < grailsApplication.config.grails.data.forecast.principals.size; j++){

            for(int k = 0;  k < grailsApplication.config.grails.data.forecast.days.size; k++){
                    def investment = new Investment()

                    investment.ranking = investmentRanking
                    investmentRanking++

                    investment.principal = Float.parseFloat(grailsApplication.config.grails.data.forecast.principals.get(j))
                    investment.rate = forecast.asset.stock.capm
                    investment.days = Integer.parseInt(grailsApplication.config.grails.data.forecast.days.get(k))
                    investment.interest = FinancialCalculator.getInstance().getInterest(investment.principal,
                                                                                        investment.rate,
                                                                                        investment.days)
                    forecast.addToInvestments(investment)
                }    
            }
            report.addToForecasts(forecast)
        }
    }
        
    def  getOverall() {
        
    
        def report = new OverallReport()
        report.summary = new Summary()
            if(grailsApplication.config.grails.data.source.proxy.enable){
                for (int i = 0; i < grailsApplication.config.grails.data.source.proxy.protocol.size; i++){
                    authentication.setProxy(grailsApplication.config.grails.data.source.proxy.protocol.get(i) ,
                    grailsApplication.config.grails.data.source.proxy.user ,
                    grailsApplication.config.grails.data.source.proxy.password ,
                    grailsApplication.config.grails.data.source.proxy.server ,
                    grailsApplication.config.grails.data.source.proxy.port)
                }
            }

            def assetList = GoogleFinanceJSON.getTopCompanies(Integer.parseInt(grailsApplication.config.grails.data.assets.items),
                grailsApplication.config.grails.data.source.google.finance.server )

            def bondList = TreasuryXML.getDailyTreasuryBonds(grailsApplication.config.grails.data.source.treasury.dailytreasury.server, new Date())
            report.summary.riskFree = bondList.get(0).rate

            def marketReturn = GoogleFinanceJSON.getMarketReturn(grailsApplication.config.grails.data.source.google.finance.market,
                grailsApplication.config.grails.data.source.google.finance.server);
            report.summary.marketReturn = marketReturn
        
            for (int i = 0; i < assetList.size; i++){
                def asset = new Asset()
                asset.ranking = i
                asset.company = new Company(name: assetList.get(i).company.name, 
                    symbol : assetList.get(i).company.symbol, 
                    marketcap: assetList.get(i).company.marketcap, 
                    state : assetList.get(i).company.state, 
                    zipcode : assetList.get(i).company.zipcode )

                def capm = FinancialCalculator.getInstance().getCAPM(report.summary.riskFree,
                                                                    report.summary.marketReturn,
                                                                    assetList.get(i).stock.beta);

                asset.stock = new Stock(marketprice : assetList.get(i).stock.marketprice, 
                    pricechange : assetList.get(i).stock.pricechange, 
                    beta: assetList.get(i).stock.beta, 
                    capm:capm)  
                report.addToAssets(asset)
            }
            def fixedList = report.assets.findAll{it.stock.beta >= 0}
                       
            int forecastRanking = 0
        
            def list = fixedList.sort{a,b-> b.stock.beta<=>a.stock.beta}
            populateForecasts(forecastRanking,list,report)
            forecastRanking = list.size
        
            list = fixedList.sort{it.stock.beta}
            populateForecasts(forecastRanking,list,report)
            
            report.summary.date = new Date()
            return report
        }
        
    def getDailyReport(){
        
        OverallReport report = getOverall()
        report.save();
        
        NumberFormat percent = NumberFormat.getPercentInstance()
        percent.maximumFractionDigits = 2
        percent.minimumFractionDigits = 2
        
        NumberFormat currency = NumberFormat.getCurrencyInstance()
        currency.setCurrency(Currency.getInstance("USD"));
        currency.maximumFractionDigits = 2
        currency.minimumFractionDigits = 2
        
        
        def txt = ""
        
        //Summary
        txt += "SUMMARY\n"
        txt += "--------------------------------------------------------------------\n"
        txt += "Date: " + report.summary.date + "\n";
        txt += "Risk Free: " +  percent.format(report.summary.riskFree/100) + "\n";
        txt += "Market Return: " +  percent.format(report.summary.marketReturn/100) + "\n";
        txt += "====================================================================\n"
        txt += "Top " + grailsApplication.config.grails.data.assets.items + " Companies\n"
        txt += "--------------------------------------------------------------------\n"
        txt += "Rank    |\n"
        
        def assets = report.assets.asList().sort{it.ranking}
        for (int i = 0; i < assets.size; i++){
            txt += "--------------------------------------------------------------------\n"
            txt += assets.get(i).ranking + "       |\n"
            txt += "\t| Company\n"
            txt += "\t|\t Name: " + assets.get(i).company.name + "\n"
            txt += "\t|\t Symbol: " + assets.get(i).company.symbol + "\n"
            txt += "\t|\t Market Cap: USD" + assets.get(i).company.marketcap + "\n"
            txt += "\t|\t State: " + assets.get(i).company.state + "\n"
            txt += "\t|\t Zipcode: " + assets.get(i).company.zipcode + "\n"
            txt += "\t|\n"
            txt += "\t| Stock\n"
            txt += "\t|\t Market Price: " + currency.format(assets.get(i).stock.marketprice) + "\n"
            txt += "\t|\t Change: " +  percent.format(assets.get(i).stock.pricechange/100) + "\n"
            if(assets.get(i).stock.beta < 0){
                txt += "\t|\t Beta value: N/A\n"
                txt += "\t|\t CAPM: N/A \n"
                
            }else{
                txt += "\t|\t Beta value: " + assets.get(i).stock.beta + "\n"
                txt += "\t|\t CAPM: " + percent.format(assets.get(i).stock.capm/100) + "\n"
            }
        }
        txt += "====================================================================\n"
        txt += "The " + grailsApplication.config.grails.data.forecast.items + " more risky\n"
        txt += "--------------------------------------------------------------------\n"        
        def forecasts = report.forecasts.asList().sort{it.ranking}
        for(int i = 0; i < forecasts.size; i++){
            txt += "Symbol: " + forecasts.get(i).asset.company.symbol + "\n"
            txt += "CAPM: " + percent.format(forecasts.get(i).asset.stock.capm/100) + "\n"
            txt += "--------------------------------------------------------------------\n"
            def investments = forecasts.get(i).investments.asList().sort{it.ranking}
            for(int j = 0; j <investments.size; j++){
                txt += "\tPrincipal: " + currency.format(investments.get(j).principal) + "\n"
                txt += "\tDays: " + investments.get(j).days + "\n";
                txt += "\tCash earnings: " + currency.format(investments.get(j).interest) + "\n" 
                txt += "\tInterest: " + percent.format(investments.get(j).interest/investments.get(j).principal) + "\n";
                txt += "\t---\n"
            }
            
            txt += "--------------------------------------------------------------------\n"            
            if(i ==  Integer.parseInt(grailsApplication.config.grails.data.forecast.items)-1){
                txt += "====================================================================\n"
                txt += "The " + grailsApplication.config.grails.data.forecast.items + " more stable\n"
            }
        }       
        return txt
    }
        
}
