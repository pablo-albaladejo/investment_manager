<%-- 
    Document   : _list
    Created on : 21-jul-2014, 17:06:10
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
 <body>
    <div id="page-body" role="main">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>E-mail</th>
            </tr>
        </table>     
        <div id="emailsDiv" style="overflow:scroll;height:400px; overflow:auto" onscroll="OnScrollDiv(this)">
        <table id="emailsTable">
            <tbody>
            <g:render template = 'rows' model="[list:list]"/>   
            </tbody>
        </table>
        </div>
      </div>
  </body>