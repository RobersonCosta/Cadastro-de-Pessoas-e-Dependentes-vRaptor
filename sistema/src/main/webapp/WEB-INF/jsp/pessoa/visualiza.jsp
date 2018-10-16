<%-- 
    Document   : tela_visualiza
    Created on : 07/08/2015, 15:15:06
    Author     : iapereira
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para utilizar o foreach e o if e etc.. -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">        
        <script src="${pageContext.request.contextPath}/css/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <label><h2>Pessoa</h2></label>
            <p>
                ${pessoa.nome} ${pessoa.sobrenome}
            </p>
            
            <label><h3>Seus dependentes</h3></label>
            <table  class="table table-hover">
                <c:forEach items="${vetDependente}" var="dependente">
                    <tr>  
                        <td>${dependente.nome} </td> 
                        <td> ${dependente.sobrenome} </td>                    
                        <td> <a href="${pageContext.request.contextPath}/dependente/deletar/${dependente.id}" class="btn btn-default"> Deletar  </a> </td> 
                        <td> <a href="${pageContext.request.contextPath}/dependente/tela_editar/${dependente.id}" class="btn btn-default"> Editar  </a> </td>
                    </tr>                       
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}/dependente/tela_inserir/${pessoa.id}" class="btn btn-success"> Adicionar dependente </a>
            <a href="${pageContext.request.contextPath}/pessoa/listar" class="btn btn-success"> Retornar </a>
        </div>
    </body>
</html>
