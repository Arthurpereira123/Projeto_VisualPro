<%@page import="model.Funcionario"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="out"%>
<%
    Funcionario f = (Funcionario) session.getAttribute("funcionario");
    if(f == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VisualPro</title>
        <link rel="stylesheet" type="text/css" href="estiloperfil.css">
        <script type="text/javascript" src="javascript.js"></script>
    </head>
    <body>
        <h1 id="saudacao">Bem-Vindo (a), ${funcionario.nome}!</h1>
        <nav id="dados">
            <ul>
                <li onclick="mostrarOcultar('tblDados');">Meus Dados</li>
                <li><a onclick="mostrarOcultar('tblAtendimentos');">Meus Atendimentos</a></li>
                <li onclick="mostrarOcultar('formFuncionario');">Atualizar Meus Dados</li>
                <li><a onclick="confirmacao();" href="FuncionarioController?opcao=${cliente.id}">Remover Minha Conta</a></li>
                <li><a href="Verificacao?opcao=sair">Sair</a></li>
            </ul>
        </nav>
        
        <p><% String resposta = (String) request.getAttribute("resposta");
            if(resposta != null){
                out.println(resposta);
            }
            %>
        </p>

        <table id="tblDados" hidden>
            <tr>
                <th>Nome:</th>
                <td>${funcionario.nome}</td>
            <tr>
                <th>Login:</th>
                <td>${funcionario.login}</td>
            </tr>
            <tr>
                <th>Senha:</th>
                <td>${funcionario.senha}</td>
            </tr>
            <tr>
                <th>E-mail:</th>
                <td>${funcionario.email}</td>
            </tr>
            <tr>
                <th>Telefone:</th>
                <td>${funcionario.telefone}</td>
            </tr>
            <tr>
                <th>CPF:</th>
                <td>${funcionario.cpf}</td>
            </tr>
            <tr>
                <th>Empresa:</th><br>
                <td>${funcionario.empresa}</td>
            </tr>
            <tr>
                <th>Sua Avaliação:</th><br>
                <td>${funcionario.avaliacao}</td>
            </tr>
        </table>
            
        <form action="FuncionarioController" method="post" id="formFuncionario" hidden>
            <fieldset><legend>FUNCIONARIO</legend>
                <div id="left">
                    <legend>Nome:</legend><input type="text" name="nome" value="${funcionario.nome}" id="nome">
                    <legend>Nome de Usuário:</legend><input type="text" name="login" value="${funcionario.login}" id="login">
                    <legend>Senha:</legend><input type="password" name="senha" value="${funcionario.senha}" id="senha">
                    <legend>E-mail:</legend><input type="email" name="email" value="${funcionario.email}" id="email">
                </div>
                <div id="right">
                    <legend>Telefone:</legend><input type="text" name="telefone" value="${funcionario.telefone}" id="telefone">
                    <legend>CPF:</legend><input type="text" name="cpf" value="${funcionario.cpf}" id="cpf">
                    <legend>Empresa:</legend><input type="text" name="endereco" value="${funcionario.empresa}" id="endereco"><br><br>
                    <input type="submit" name="opcao" id="btatualizar" value="Atualizar">
                </div>
            </fieldset>
        </form>
            
        <nav id="menu">
                <ul>
                    <li><a href="index.jsp" style="font-size:1.1vw">HOME</a></li>
                    <li><a href="FuncionarioController?opcao=listfuncionarios" style="font-size:1.1vw">AGENDAMENTO</a></li>
                    <li><a href="Verificacao?opcao=redirecionar" style="font-size:1.1vw">MEU PERFIL</a></li>
                    <li><a href="servicos.jsp" style="font-size:1.1vw">SERVIÇOS</a></li>
                    <li><a href="contato.jsp" style="font-size:1.1vw">CONTATO</a></li>
                </ul>
            </nav>
    </body>
</html>