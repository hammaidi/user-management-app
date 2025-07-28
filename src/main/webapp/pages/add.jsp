<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un utilisateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@ include file="/components/navbar.jsp" %>
    
    <div class="container">
        <div class="form-container">
            <h1>Ajouter un utilisateur</h1>
            <form action="${pageContext.request.contextPath}/add.htm" method="post">
                <div class="form-group">
                    <label for="user_name">Nom :</label>
                    <input type="text" id="user_name" name="user_name" required>
                </div>
                
                <div class="form-group">
                    <label for="user_password">Mot de passe :</label>
                    <input type="password" id="user_password" name="user_password" required>
                </div>
                
                <div class="form-actions">
                    <a href="${pageContext.request.contextPath}/users1" class="btn btn-danger">Annuler</a>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>