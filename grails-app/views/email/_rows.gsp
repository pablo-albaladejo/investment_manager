<%-- 
    Document   : _rows
    Created on : 21-jul-2014, 10:36:28
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<g:each in="${list}" var="email">
    <tr><td>${email.id}</td><td>${email.name}</td><td>${email.surname}</td><td>${email.address}</td></tr>
</g:each>