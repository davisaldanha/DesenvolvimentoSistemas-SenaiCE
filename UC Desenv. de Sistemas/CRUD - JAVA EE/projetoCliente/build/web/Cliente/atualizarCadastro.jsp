<%-- 
    Document   : atualizarCadastro
    Created on : 1 de dez. de 2022, 11:10:57
    Author     : ok
--%>
<%@page import="br.com.DAO.clienteDAO"%>
<%@page import="br.com.Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>OK!</h1>

        <%
            try {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(Integer.parseInt(request.getParameter("id")));
                cliente.setNome(request.getParameter("nome"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setSenha(request.getParameter("senha"));

                clienteDAO clientedao = new clienteDAO();
                clientedao.atualizarCliente(cliente);

            } catch (Exception e) {
                System.out.println(e);
            }
            
        %>
    </body>
</html>
