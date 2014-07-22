<%--        
    Document   : list
    Created on : 19-jul-2014, 15:56:23
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<html>
  <head>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <g:javascript>
        function OnScrollDiv(div){
            if((div.scrollHeight - div.offsetHeight - div.scrollTop) == 0){
            div.scrollTop = div.scrollTop -1;
            loadMoreListItems();
            } 
        }

        function loadMoreListItems(){
            jQuery.ajax({type:'POST', 
                        url:'${request.contextPath}/email/ajax',
                        data: 'length='+document.getElementById('emailsTable').rows.length,
                        beforeSend:function(XMLHttpRequest,textStatus){startSpinner();},
                        success:function(data,textStatus){jQuery('#emailsTable>tbody').append(data);},
                        error:function(XMLHttpRequest,textStatus,errorThrown){stopSpinner();},
                        complete:function(XMLHttpRequest,textStatus){stopSpinner();}});          
        }
        function onLoadFunction(){
            loadMoreListItems();
        }
    </g:javascript>
    <title>List all users</title>
    </head>
    <g:render template = 'list' model="[list:list]"/>
</html>
