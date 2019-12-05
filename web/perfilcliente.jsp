<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="out"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VisualPro</title>
        <link rel="stylesheet" type="text/css" href="estiloperfil.css">
        <script type="text/javascript" src="javascript.js"></script>
    </head>
    <body>
        <h1 id="saudacao">Bem-Vindo (a), ${cliente.nome}!</h1>
        <nav id="dados">
            <ul>
                <li onclick="mostrarOcultar('tblDados');">Meus Dados</li>
                <li><a href="ListadeFuncionarios">Agendar Atendimento</a></li>
                <li onclick="mostrarOcultar('formCliente');">Atualizar Meus Dados</li>
                <li><a href="ClienteController?opcao=${cliente.id}" onclick="confirmacao();">Remover Minha Conta</a></li>
                <li><a href="ValidaSessao">Sair</a></li>
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
                <td>${cliente.nome}</td>
            <tr>
                <th>Login:</th>
                <td>${cliente.login}</td>
            </tr>
            <tr>
                <th>Senha:</th>
                <td>${cliente.senha}</td>
            </tr>
            <tr>
                <th>E-mail:</th>
                <td>${cliente.email}</td>
            </tr>
            <tr>
                <th>Telefone:</th>
                <td>${cliente.telefone}</td>
            </tr>
            <tr>
                <th>CPF:</th>
                <td>${cliente.cpf}</td>
            </tr>
            <tr>
                <th>Endereço:</th><br>
                <td>${cliente.endereco}</td>
            </tr>
        </table>
            
        <form action="UpdateCliente" method="post" id="formCliente" hidden>
            <fieldset><legend>CLIENTE</legend>
                <div id="left">
                    <legend>Nome:</legend><input type="text" name="nome" value="${cliente.nome}" id="nome">
                    <legend>Nome de Usuário:</legend><input type="text" name="login" value="${cliente.login}" id="login">
                    <legend>Senha:</legend><input type="password" name="senha" value="${cliente.senha}" id="senha">
                    <legend>E-mail:</legend><input type="email" name="email" value="${cliente.email}" id="email">
                </div>
                <div id="right">
                    <legend>Telefone:</legend><input type="text" name="telefone" value="${cliente.telefone}" id="telefone">
                    <legend>CPF:</legend><input type="text" name="cpf" value="${cliente.cpf}" id="cpf">
                    <legend>Endereço:</legend><input type="text" name="endereco" value="${cliente.endereco}" id="endereco">
                    <legend>Id</legend><input type="text" name="id" value="${cliente.id}" readonly="readonly" id="id">
                    <input type="submit" id="btatualizar" value="Atualizar">
                </div>
            </fieldset>
        </form>
            
        <nav id="menu">
                <ul>
                    <li><a href="index.jsp" style="font-size:1.1vw">HOME</a></li>
                    <li><a href="ListadeFuncionarios" style="font-size:1.1vw">AGENDAMENTO</a></li>
                    <li><a href="Verificacao" style="font-size:1.1vw">MEU PERFIL</a></li>
                </ul>
            </nav>
    </body>
</html>