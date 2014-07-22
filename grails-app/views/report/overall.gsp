<%-- 
    Document   : overall
    Created on : 14-jul-2014, 15:59:57
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <g:javascript>
            function onLoadFunction(){
                updateOverall();
                var milliseconds = ${Integer.parseInt(grailsApplication.config.grails.data.assets.seconds)} * 1000;
                setInterval(function(){updateOverall();},milliseconds);
            }
            function updateOverall(){
                <g:remoteFunction action="ajax" update="content" before="startSpinner()" onComplete="stopSpinner()"/>
            }
        </g:javascript>
    </head>   
    <body>
    <div id="page-body" role="main">    
        <div id="content">
        </div>
    </div>
    </body>
</html>
