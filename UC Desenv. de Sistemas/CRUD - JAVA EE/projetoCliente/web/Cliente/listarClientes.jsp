<%-- 
    Document   : listarClientes
    Created on : 29 de nov. de 2022, 09:12:19
    Author     : ok
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.DAO.clienteDAO, br.com.Model.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <h1>Clientes Cadastrados</h1>
        
        <%
            clienteDAO clientedao = new clienteDAO();
            ArrayList<Cliente> lista = clientedao.listarCliente();
            request.setAttribute("list", lista);
        %>
        
        <table class="table">
            <thead>
                <tr>
                    <th class="col">ID</th>
                    <th class="col">Nome</th>
                    <th class="col">Email</th>
                    <th class="col">Senha</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="cliente">
                <tr>
                    <td scope="row"><c:out value="${cliente.getId_cliente()}" /></td>
                    <td><c:out value="${cliente.getNome()}" /></td>
                    <td><c:out value="${cliente.getEmail()}" /></td>
                    <td><c:out value="${cliente.getSenha()}" /></td>
                    <td><a href="deletarDado.jsp?id=${cliente.getId_cliente()}&nome=${cliente.getNome()}">Excluir</a></td>
                    <td><a href="atualizarDado.jsp?id=${cliente.getId_cliente()}&nome=${cliente.getNome()}&email=${cliente.getEmail()}&senha=${cliente.getSenha()}">Editar</a></td>
                </tr>               
            </c:forEach>           
            </tbody>
        </table>
        
        
    </body>
</html>
