<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VisuaPro</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="estiloagendamento.css">
    <link rel="stylesheet" type="text/css" href="formularios.css">
</head>

<body>
    <header id="cabecalho">
        <h1>VisualPro</h1>           
        
        <form action="AgendamentoController" method="get" id="formagendamento">
            <select id="fun" size="8" name="funcionario">
                <c:forEach items="${funcionarios}" var="funcionario">
                    <option><c:out value="${funcionario.nome}"/></option>
                </c:forEach>
            </select><br>
        
            <select name="hora">
                <option>08:00</option>
                <option>09:00</option>
                <option>10:00</option>
                <option>11:00</option>
                <option>13:00</option>
                <option>14:00</option>
                <option>15:00</option>
                <option>16:00</option>
                <option>17:00</option>
                <option>18:00</option>
            </select>

            <select name="data">
                <option>06/12/2019</option>
                <option>07/12/2019</option>
                <option>08/12/2019</option>
                <option>09/12/2019</option>
                <option>10/12/2019</option>
                <option>11/12/2019</option>
                <option>12/12/2019</option>
                <option>13/12/2019</option>
                <option>14/12/2019</option>
                <option>15/12/2019</option>
            </select>
            <input type="submit" name="agendar" value="Agendar">
        </form>
        
        <nav id="avaliar">
            <ul>
                <li>Avalar atendimento</li>
            </ul>
        </nav>
        
        <form action="AgendamentoController" method="post" id="avaliacao">
            0<input type="range" min="0" max="10">10
        </form>
        
        <p><% String resposta = (String) request.getAttribute("resposta");
                if(resposta != null){
                    out.println(resposta);
                }
            %></p>
        
        <nav id="menu">
            <ul>
                <li><a href="index.jsp" style="font-size:1.1vw">HOME</a></li>
                <li><a href="ListadeFuncionarios" style="font-size:1.1vw">AGENDAMENTO</a></li>
                <li><a href="Verificacao" style="font-size:1.1vw">MEU PERFIL</a></li>
            </ul>
        </nav>
    </header>
</body>
</html>