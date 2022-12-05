<%-- 
    Document   : deletarDado
    Created on : 1 de dez. de 2022, 08:54:31
    Author     : ok
--%>

<%@page import="br.com.DAO.clienteDAO"%>
<%@page import="br.com.Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário Dead</title>
    </head>
    <body>
        <h1><%=request.getParameter("nome")%></span> excluído do banco de Dados</h1>
        <%
            Cliente cliente = new Cliente();
            cliente.setId_cliente(Integer.parseInt(request.getParameter("id")));
            
            clienteDAO clientedao = new clienteDAO();
            clientedao.excluirCliente(cliente);
        
        %>
    </body>
</html>
