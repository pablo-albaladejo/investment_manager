<%-- 
    Document   : add_body
    Created on : 21-jul-2014, 16:55:01
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<body>
      <div id="page-body" role="main">  
      <g:form controller="email" action="save">
            <table >
            <tr>
                <td><label>First Name: </label></td>
                <td><g:textField name="name" value="${fieldValue(bean:email,field:'name')}"/><br/></td>
            </tr>
            <tr>
                <td><label>Surname: </label></td>
                <td><g:textField name="surname" value="${fieldValue(bean:email,field:'surname')}"/><br/></td>
            </tr>
            <tr>
                <td><label>Email: </label></td>
                <td><g:textField name="address" value="${fieldValue(bean:email,field:'address')}"/><br/></td>
            </tr>
            <tr>
                <td><g:actionSubmit value="Save"/></td>
            </tr>
            </table>
        </g:form>
        <g:hasErrors bean="${email}">
            <div class="errors">
                <g:renderErrors bean="${email}" as="list" />
            </div>
        </g:hasErrors>
      </div>
  </body>
