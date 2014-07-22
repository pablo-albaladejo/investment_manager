<%-- 
    Document   : overall_mobile
    Created on : 21-jul-2014, 17:14:53
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<html>
  <head>
    <meta name="layout" content="mobile"/>
     <g:javascript>
            function onLoadFunction(){
                updateOverall();
                var milliseconds = ${Integer.parseInt(grailsApplication.config.grails.data.assets.seconds)} * 1000;
                setInterval(function(){updateOverall();},milliseconds);
            }
            
            function startLoading(){
                document.getElementById('info').innerHTML = "<h1><i>Loading...</i></h1>";
            }
             
            function stopLoading(){
                document.getElementById('info').innerHTML = "";
            }
            
            function updateOverall(){
                <g:remoteFunction action="ajax" update="content" before="startLoading()" onComplete="stopLoading()"/>
            }
        </g:javascript>
    </head>   
    <body>
    <div id="page-body" role="main">    
        <div id="info"></div>
        <div id="content">
        </div>
    </div>
    </body>
</html>
