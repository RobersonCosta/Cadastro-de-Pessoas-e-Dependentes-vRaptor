<%-- 
    Document   : index
    Created on : 11/06/2014, 16:00:08
    Author     : Valdinei.Silva
--%>

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
            <label><h3>Inserindo um dependente</h3></label>
            <form role="form" action="${pageContext.request.contextPath}/dependente/inserir" method="post">

                <div class="form-group">
                    <label>Nome: </label><input type="text" name="dependente.nome" class="form-control"><br>
                </div>  <div class="form-group">
                    <label>Sobrenome: </label><input type="text" name="dependente.sobrenome" class="form-control">
                </div>
                <input type="hidden" value="${pessoa.id}" name="dependente.pessoa.id">
                <input type="submit" class="btn btn-default">
            </form>
        </div>
    </body>
</html>
