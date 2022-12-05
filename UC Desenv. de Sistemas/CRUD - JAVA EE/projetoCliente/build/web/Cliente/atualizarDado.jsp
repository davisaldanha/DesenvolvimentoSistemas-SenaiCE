<%-- 
    Document   : atualizarDado
    Created on : 1 de dez. de 2022, 10:34:06
    Author     : ok
--%>

<%@page import="br.com.Model.Cliente"%>
<%@page import="br.com.DAO.clienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Dados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        
    </head>
    <body>
        <h3 >Atualizar dados do <%=request.getParameter("nome")%></h3>
        <a href="listarClientes.jsp"><button class="btn btn-success">Listar Clientes</button></a>
        <a href="cadastro.html"><button class="btn btn-success">Novo Cliente</button></a>
        <br /> <br />
        <form action="atualizarDado.jsp?id=<%=request.getParameter("id")%>" method="POST">
            <label>ID: </label>
            <input type="text"class="form-control" name="id" value="<%=request.getParameter("id")%>" disabled><br />           
            <label>Nome: </label>
            <input type="text" class="form-control" name="nome" value="<%=request.getParameter("nome")%>")><br />
            <label>Email: </label>
            <input type="email" class="form-control" name="email" value="<%=request.getParameter("email")%>"><br />
            <label>Senha: </label>
            <input type="password" class="form-control" name="senha" value="<%=request.getParameter("senha")%>"><br /><br />

            <button type="submit" class="btn btn-primary">Atualizar</button>
            
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
        </form>
    </body>
</html>
