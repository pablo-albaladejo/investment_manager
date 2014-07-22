package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class GoogleFinanceJSON {

    private static class Company {
        
        private String name;
        private String symbol;
        private String marketcap;
        private String state;
        private String zipcode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getMarketcap() {
            return marketcap;
        }

        public void setMarketcap(String marketcap) {
            this.marketcap = marketcap;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
        
                
    }
        
    private static class Stock {
        private Float marketprice;
        private Float pricechange;
        private Float beta;
        private Float camp;

        public Float getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(Float marketprice) {
            this.marketprice = marketprice;
        }

        public Float getPricechange() {
            return pricechange;
        }

        public void setPricechange(Float pricechange) {
            this.pricechange = pricechange;
        }

        public Float getBeta() {
            return beta;
        }

        public void setBeta(Float beta) {
            this.beta = beta;
        }

        public Float getCamp() {
            return camp;
        }

        public void setCamp(Float camp) {
            this.camp = camp;
        }
    }
    
    private static class Asset{
        private Company company;
        private Stock stock;

        public Asset() {
            company = new Company();
            stock = new Stock();
        }
        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public Stock getStock() {
            return stock;
        }

        public void setSotck(Stock stock) {
            this.stock = stock;
        }
        
    }
    
    public static Float getMarketReturn(String market, String baseUrl){
        Float value = 0.0f;
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        String marketUrl = baseUrl;
            marketUrl += "q="+market;
            marketUrl += "&output=json";
            
        JsonObject jsonMarket = JSONService.getJsonObject(marketUrl);
        JsonArray keyratios = jsonMarket.get("keyratios").getAsJsonArray();
        for(int i = 0; i < keyratios.size(); i++){
            JsonObject keyratio = keyratios.get(i).getAsJsonObject();
           if(keyratio.get("title").getAsString().compareTo("Return on average assets") == 0){
                try {
                    value = numberFormat.parse(keyratio.get("ttm").getAsString()).floatValue();
                } catch (ParseException ex) {
                    value = 0.0f;
                }
           }
        }        
        return value;
    }
    
    public static List getTopCompanies(int num, String baseUrl){
        //http://stackoverflow.com/questions/9656369/java-lang-numberformatexception-for-input-string-20-475-00
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US); 
                
        String assetsUrl = baseUrl;
        assetsUrl += "&num="+num;
        assetsUrl += "&q=[%28exchange+%3D%3D+%22NASDAQ%22%29+%26+%28market_cap+%3E%3D"+Integer.MIN_VALUE+"%29+%26+%28last_price+%3E%3D"+Integer.MIN_VALUE+"%29+%26+%28change_today_percent+%3E%3D"+Integer.MIN_VALUE+"%29+%26+%28beta+%3E%3D+"+Integer.MIN_VALUE+"%29]&restype=company&noIL=1&sortas=MarketCap&output=json";
        
        List list = new ArrayList();
        
        JsonObject jsonAssets = JSONService.getJsonObject(assetsUrl);
        JsonArray searchresults = jsonAssets.get("searchresults").getAsJsonArray();

        for(int i = 0; i < searchresults.size(); i++){
            Asset asset = new Asset();
            
            JsonObject jsonCompany = searchresults.get(i).getAsJsonObject();
            asset.getCompany().setName(jsonCompany.get("title").getAsString());
            asset.getCompany().setSymbol(jsonCompany.get("ticker").getAsString());
            
            String detailUrl = baseUrl;
            detailUrl += "q=NASDAQ:"+asset.getCompany().getSymbol()+"&output=json";
           
            JsonObject jsonDetail = JSONService.getJsonObject(detailUrl);
            
            JsonElement jsonSummay = jsonDetail.get("summary");
            if(jsonSummay != null){
                JsonObject summary = jsonSummay.getAsJsonArray().get(0).getAsJsonObject();
                String address = summary.get("address").getAsString();
                String [] addressArray = address.split(",");
                
                String composed = addressArray[addressArray.length-2];
                String [] composedArray = composed.split(" ");
                
                asset.getCompany().setZipcode(composedArray[composedArray.length-1]);
                asset.getCompany().setState(composedArray[composedArray.length-2]);
            }
            
            JsonArray columns = jsonCompany.get("columns").getAsJsonArray();            
            for(int j = 0; j < columns.size(); j++){
                JsonObject jsonColumn = columns.get(j).getAsJsonObject();
                String columName = jsonColumn.get("field").getAsString();
                
                if(columName.compareTo("MarketCap") == 0){
                    asset.getCompany().setMarketcap(jsonColumn.get("value").getAsString());
                }else if(columName.compareTo("QuoteLast") == 0){
                    Float value;
                    try {
                        value = numberFormat.parse(jsonColumn.get("value").getAsString()).floatValue();
                    } catch (ParseException ex) {
                        value = 0.0f;
                    }
                    asset.getStock().setMarketprice(value);
                }else if(columName.compareTo("Beta") == 0){
                    Float value = -1.0f;
                    if(jsonColumn.get("value").getAsString().compareTo("-") != 0 ){
                        try {
                            value = numberFormat.parse(jsonColumn.get("value").getAsString()).floatValue();
                        } catch (ParseException ex) {
                            value = -1.0f;
                        }
                    }
                    asset.getStock().setBeta(value);
                }else if(columName.compareTo("QuotePercChange") == 0){
                    Float value;
                    try {
                        value = numberFormat.parse(jsonColumn.get("value").getAsString()).floatValue();
                    } catch (ParseException ex) {
                        value = 0.0f;
                    }
                    asset.getStock().setPricechange(value);
                }      
            }
            list.add(asset);
            }
        return list;
    }

}
