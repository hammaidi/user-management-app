<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Utilisateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@ include file="/components/navbar.jsp" %>
    
    <div class="container">
        <div class="form-container">
            <h1>Modifier l'utilisateur</h1>
            <form action="${pageContext.request.contextPath}/update.htm" method="post">
                <input type="hidden" name="id" value="${user.user_id}"> <!-- Changé de user_id à id -->
                
                <div class="form-group">
                    <label for="user_name">Nom :</label>
                    <input type="text" id="user_name" name="user_name" value="${user.user_name}" required>
                </div>
                
                <div class="form-group">
                    <label for="user_password">Mot de passe :</label>
                    <input type="password" id="user_password" name="user_password" value="${user.user_password}" required>
                </div>
                
                <div class="form-actions">
                    <a href="${pageContext.request.contextPath}/users1" class="btn btn-danger">Annuler</a>
                    <button type="submit" class="btn btn-primary">Mettre à jour</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>