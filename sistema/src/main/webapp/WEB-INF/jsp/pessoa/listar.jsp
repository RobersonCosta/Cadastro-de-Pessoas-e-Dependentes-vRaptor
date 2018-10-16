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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">        
        <script src="${pageContext.request.contextPath}/css/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <div class="container">
            
            <label><h3>Lista de pessoas</h3></label>
            <div class="row" >
                <table  class="table table-hover">
                    <c:forEach items="${vetPessoa}" var="pessoa">
                        <tr>                              
                            <td>${pessoa.nome} </td> 
                            <td> ${pessoa.sobrenome} </td> 
                            <td> <a href="${pageContext.request.contextPath}/pessoa/visualiza/${pessoa.id}" class="btn btn-default"> Visualizar  </a> </td>
                            <td> <a href="${pageContext.request.contextPath}/pessoa/deletar/${pessoa.id}" class="btn btn-default"> Deletar  </a> </td> 
                            <td> <a href="${pageContext.request.contextPath}/pessoa/tela_editar/${pessoa.id}" class="btn btn-default"> Editar  </a> </td>
                        </tr>                       
                    </c:forEach>
                </table>
            </div>
            <a href="${pageContext.request.contextPath}/pessoa/tela_inserir" class="btn btn-success"> Adicionar </a>
            <a href="${pageContext.request.contextPath}/" class="btn btn-success"> Retornar </a>

    </body>
</html>
