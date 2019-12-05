<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visual Pro</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="formularios.css">
        <script type="text/javascript" src="javascript.js"></script>
    </head>

    <body>
        <header id="cabecalho">
            <h1>VisualPro</h1>
            <nav id="forms">
                <ul>
                    <li onclick="mostrarForm('formCliente');">Cadastro de Cliente</li>
                    <li onclick="mostrarForm('formFuncionario');">Cadastro de Funcionário</li>
                </ul>
            </nav>
            
            <img src="" id="imgcadastro"/>
            <p id="confirmacao"><% String cadastro = (String) request.getAttribute("resposta");
                if(cadastro != null){
                    out.println(cadastro);
                }
                %>
            </p>
            
            <form action="ClienteController" method="post" id="formCliente" hidden>
                <fieldset><legend>CLIENTE</legend>
                    <div id="left">
                        <legend>Nome:</legend><input type="text" name="nome" placeholder="Nome Completo" id="nome">
                        <legend>Nome de Usuário:</legend><input type="text" name="login" placeholder="Nome De Usuário" id="login">
                        <legend>Senha:</legend><input type="password" name="senha" placeholder="Escolha uma senha" id="senha">
                        <legend>E-mail:</legend><input type="email" name="email" placeholder="Digite o seu E-mail" id="email">
                    </div>
                    <div id="right">
                        <legend>Telefone:</legend><input type="text" name="telefone" minlength="7" maxlength="15" placeholder="Número para contato" id="telefone">
                        <legend>CPF:</legend><input type="text" name="cpf" minlength="11" maxlength="14" placeholder="Digite seu CPF" id="cpf">
                        <legend>Endereço:</legend><input type="text" name="endereco" placeholder="Digite seu Endereço" id="endereco"><br><br>
                        <input type="submit" name="opcao" id="btcadastrar" value="Cadastrar">
                    </div>
                </fieldset>
            </form>
            
            <form action="FuncionarioController" method="post" id="formFuncionario" hidden>
                <fieldset><legend>FUNCIONÁRIO</legend>
                    <div id="left">	
                        <legend>Nome:</legend><input type="text" name="nome" placeholder="Nome Completo" id="nome">
                        <legend>Nome de Usuário:</legend><input type="text" name="login" placeholder="Nome de Usuário" id="login">
                        <legend>Senha:</legend><input type="password" name="senha" placeholder="Escolha uma senha" id="senha">
                        <legend>E-mail:</legend><input type="email" name="email" placeholder="E-mail Empresarial" id="email">
                    </div>
                    <div id="right">
                        <legend>Telefone:</legend><input type="text" name="telefone" minlength="7" maxlength="15" placeholder="Número para contato" id="telefone">
                        <legend>CPF:</legend><input type="text" name="cpf" minlength="11" maxlength="14" placeholder="Digite seu CPF" id="cpf">
                        <legend>Empresa:</legend><input type="text" name="empresa" placeholder="Nome da Empresa" id="empresa"><br><br>
                        <input type="submit" name="opcao" id="btcadastrar" value="Cadastrar"><br><br>
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
        </header>
    </body>
</html>