<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visual Pro</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="formularios.css">
        <script type="text/javascript" src="javascript.js"></script>
    </head>
    <body>
        <header id="cabecalho">
            <form action="Verificacao" method="post" name="fLogin" id="fLogin">
                <fieldset id="campoLogin"><legend>DADOS DE ACESSO</legend>
                    <legend>LOGIN:</legend><input type="text" name="login" id="login" placeholder="Nome de Usuário" size="15" maxlength="20"><br><br>
                    <legend>SENHA:</legend><input type="password" name="senha" id="senha" placeholder="Digite sua senha" size="15" minlength="8" maxlength="20"><br><br><br>
                    <input type="submit" value="Entrar" id="entrar">
                </fieldset>
            </form>
            <p><% String resposta = (String) request.getAttribute("resposta");
                if(resposta != null){
                    out.println(resposta);
                }
               %>
            </p>
            
            <nav id="menu">
                <ul>
                    <li><a href="index.jsp" style="font-size:1.1vw">HOME</a></li>
                    <li><a href="ListadeFuncionarios" style="font-size:1.1vw">AGENDAMENTO</a></li>
                    <li><a href="servicos.jsp" style="font-size:1.1vw">SERVIÇOS</a></li>
                </ul>
            </nav>
        </header>
    </body>
</html>