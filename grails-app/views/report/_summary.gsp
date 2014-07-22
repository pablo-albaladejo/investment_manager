<%-- 
    Document   : _summary
    Created on : 19-jul-2014, 20:21:49
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<h1>Summary</h1>    
<table>
    <tr><th>Overall Report</th><tr>
    <tr><td>Date: <g:formatDate date="${summary.date}" type="datetime" style="LONG" timeStyle="LONG" locale="US"/></td></tr>
    <tr><td>Risk Free: <g:formatNumber number="${summary.riskFree/100}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td></tr>
    <tr><td>Market Return: <g:formatNumber number="${summary.marketReturn/100}" type="percent" minFractionDigits="2" maxFractionDigits="2"/></td></tr>            
</table>
<hr>