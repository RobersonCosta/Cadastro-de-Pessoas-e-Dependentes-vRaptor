<%-- 
    Document   : index
    Created on : 11/06/2014, 16:00:08
    Author     : Valdinei.Silva
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para utilizar o foreach e o if e etc.. -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">        
        <script src="${pageContext.request.contextPath}/css/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>

    <body>        
        <div class="container">
            
            <label><h3>Lista de dependentes</h3></label>
            <div class="row" >
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
                <a href="${pageContext.request.contextPath}/" class="btn btn-success"> Retornar </a>
            </div>
    </body>
</html>
