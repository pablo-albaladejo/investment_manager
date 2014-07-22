<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><g:layoutTitle default="Investment Manager"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
        <asset:stylesheet src="mobile.css"/>
        <asset:javascript src="application.js"/>
        <g:layoutHead/>
    </head>
    <body onload="onLoadFunction()">
            <div id="investmentmanagerLogo" role="banner"><a href="http://investmentmanager.org"><asset:image src="investmentmanager_logo.png" alt="Investment Manager"/></a></div>
            <div id="menu" role="complementary">
                <h1>Quick links</h1>
                    <ul><g:link uri="/mobile">Home</g:link></ul>
                <h1>Reports</h1>
                <ul>
                    <li><g:link controller="report" action="overall">Overall</g:link></li>
                    <li><g:link controller="report" action="json">JSON</g:link></li>
                </ul>
                <h1>E-Mailing</h1>
                <ul>
                    <li><g:link controller="email" action="add">New user</g:link></li>
                    <li><g:link controller="email" action="list">List all users</g:link></li>
                </ul>
            </div>
            <div id="spinner" style="display:none;" ><center><img src="${assetPath(src: 'spinner.gif')}" alt="<g:message code="spinner.alt" default="Loading&hellip;"/>"></center></div>
            <g:layoutBody/>
            <div class="footer" role="contentinfo">
                <i>Pablo Albaladejo Mestre - pablo.albaladejo.mestre@gmail.com</i>
            </div>
    </body>
</html>
