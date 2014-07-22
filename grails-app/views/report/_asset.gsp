<%-- 
    Document   : assets
    Created on : 19-jul-2014, 18:49:29
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<h1>Top ${Integer.parseInt(grailsApplication.config.grails.data.assets.items)} Companies</h1>
<table>
    <tr>
        <th>Rank</th>
        <th>Company</th>
        <th>Stock</th>
    </tr>
</table>
<div style="overflow:scroll;height:280px;overflow:auto">
<table>

    <g:each in="${list.sort{it.ranking}}" var="asset">
    <tr>
        <td> ${asset.ranking + 1}</td>
        <td>
            <table>
                <tr>
                    <td>Name</td><td> ${asset.company.name}</td>
                </tr>
                <tr>
                    <td>Symbol</td><td> ${asset.company.symbol}</td>
                </tr>
                <tr>
                    <td>Market Cap</td><td>USD${asset.company.marketcap}</td>
                </tr>
                <tr>
                    <td>State</td><td> ${asset.company.state}</td>
                </tr>
                <tr>
                    <td>Zip Code</td><td> ${asset.company.zipcode}</td>
                </tr>
            </table>
        </td>
        <td>
            <table>
                <tr>
                    <td>Market Price</td><td><g:formatNumber number="${asset.stock.marketprice}" type="currency" currencyCode="USD"/></td>
                </tr>
                <tr>
                    <td>Change</td><td><g:formatNumber number="${asset.stock.pricechange/100}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td>
                </tr>
                <tr>
                    <td>Beta value</td>
                    <g:if test="${asset.stock.beta > 0}">
                        <td> ${asset.stock.beta}</td>
                    </g:if>
                    <g:else>
                        <td> N/A </td>
                    </g:else>
                </tr>
                <tr>
                    <td>CAPM</td>
                    <g:if test="${asset.stock.capm > 0}">
                        <td><g:formatNumber number="${asset.stock.capm/100}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td>
                    </g:if>
                    <g:else>
                        <td> N/A </td>
                    </g:else>
                </tr>
            </table>
        </td>
    </tr>
    </g:each>
</table>
</div>
<hr>