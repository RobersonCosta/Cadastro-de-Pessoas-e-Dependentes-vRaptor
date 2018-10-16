<%-- 
    Document   : index
    Created on : 11/06/2014, 16:00:08
    Author     : Valdinei.Silva
--%>

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
            <label><h3>Clique em alguma das opções abaixo</h3></label><br>
            <a href="${pageContext.request.contextPath}/pessoa/listar" class="btn btn-success"> Manipular Pessoa </a>
            <a href="${pageContext.request.contextPath}/dependente/listar" class="btn btn-success"> Manipular Dependente </a>
        </div>    
    </body>
</html>
