<%-- 
    Document   : forecasts
    Created on : 19-jul-2014, 19:29:46
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<h1>Forecasts</h1>
<g:each in="${list.sort{it.ranking}}" var="forecast" status="i">
    
    <g:if test="${i == 0}">
        <h2>The ${Integer.parseInt(grailsApplication.config.grails.data.forecast.items)} more risky</h2>
        <table>
            <tr>
                <th>Symbol</th>
                <th>CAPM</th>
                <th>Forecast</th>
            </tr>
        </table>
        <div style="overflow:scroll;height:280px;overflow:auto">
    </g:if>
    <g:if test="${i == Integer.parseInt(grailsApplication.config.grails.data.forecast.items)}">
        <h2>The ${Integer.parseInt(grailsApplication.config.grails.data.forecast.items)} more stable</h2>
        <table>
            <tr>
                <th>Symbol</th>
                <th>CAPM</th>
                <th>Forecast</th>
            </tr>
        </table>
        <div style="overflow:scroll;height:280px;overflow:auto">
    </g:if>
    <table>
        <tr>
            <td>${forecast.asset.company.symbol}</td>
            <td><g:formatNumber number="${forecast.asset.stock.capm/100}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td>
            <td>
                <table>
                    <tr>
                        <th>investments</th><th>cash earning</th><th>interest</th>
                    </tr>
                    <g:each in="${forecast.investments.sort{it.ranking}}" var="investment">
                    <tr>
                        <td>
                            <table>
                                <tr><td>Principal</td><td><g:formatNumber number="${investment.principal}" type="currency" currencyCode="USD"/></td></tr>
                                <tr><td>Days</td><td>${investment.days}</td></tr>
                            </table>
                        </td>
                        <td><g:formatNumber number="${investment.interest}" type="currency" currencyCode="USD"/></td><td><g:formatNumber number="${investment.interest/investment.principal}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td>
                    </tr>
                    </g:each>
                </table>
            </td>
        </tr>
    </table>
    <g:if test="${i == Integer.parseInt(grailsApplication.config.grails.data.forecast.items)-1  || i == (Integer.parseInt(grailsApplication.config.grails.data.forecast.items)*2)-1}">
        </div>
    </g:if>
</g:each>
<hr>