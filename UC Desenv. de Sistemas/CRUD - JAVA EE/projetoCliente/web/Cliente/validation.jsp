<%-- 
    Document   : inserirCliente
    Created on : 24 de nov. de 2022, 01:19:36
    Author     : ok
--%>

<%@page import="br.com.DAO.clienteDAO"%>
<%@page import="br.com.Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <title> Cadastro Concluí­do!</title>
    </head>
    <body>
        <main class="container">
            <div class="validation">
                <img src="imagens\validation.png" id="picture" alt="Validation">
                <h1 class="textH1">Usuário cadastrado <br />com sucesso!</h1>
            </div>		
            <%
                try {
                    Cliente objCliente = new Cliente();
                    objCliente.setNome(request.getParameter("username"));
                    objCliente.setEmail(request.getParameter("email"));
                    objCliente.setSenha(request.getParameter("password"));

                    clienteDAO objclientedao = new clienteDAO();
                    objclientedao.cadastarCliente(objCliente);
					
                } catch (Exception e) {
                    out.print(e);
                }

            %>
        </main>
    </body>
</html>