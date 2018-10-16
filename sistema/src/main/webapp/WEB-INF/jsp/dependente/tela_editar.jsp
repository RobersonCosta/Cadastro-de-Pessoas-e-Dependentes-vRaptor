<%-- 
    Document   : tela_inserir
    Created on : 07/08/2015, 14:41:08
    Author     : iapereira
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
            <label><h3>Editando um dependente</h3></label>
            <form role="form" action="${pageContext.request.contextPath}/dependente/editar" method="post">        
                <div class="form-group">
                    <label>Nome: </label><input type="text" name="dependente.nome" value="${dependente.nome}" class="form-control"><br>   
                </div>
                <div class="form-group">                    
                    <label>Sobrenome: </label> <input type="text" name="dependente.sobrenome" value="${dependente.sobrenome}" class="form-control">
                </div>
                <input type="hidden" value="${dependente.id}" name="dependente.id" >
                <input type="hidden" value="${dependente.pessoa.id}" name="dependente.pessoa.id">
                <input type="submit" class="btn btn-default">           
            </form>
        </div>
    </body>
</html>
