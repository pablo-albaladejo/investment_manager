<%-- 
    Document   : _content
    Created on : 21-jul-2014, 13:10:14
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<g:if test="${report}">
<g:render template = 'summary' model="[summary:report.summary]"/>     
<g:render template = 'asset' model="[list: report.assets]"/>
<g:render template = 'forecast' model="[list: report.forecasts]"/>
</g:if>