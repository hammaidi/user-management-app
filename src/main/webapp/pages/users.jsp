<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Utilisateurs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%@ include file="/components/navbar.jsp" %>
    
    <div class="container">
        <h1>Liste des Utilisateurs</h1>

        <c:choose>
            <c:when test="${empty users}">
                <div class="empty-state">
                    <p>Aucun utilisateur trouvé</p>
                    <a href="${pageContext.request.contextPath}/add.htm" class="btn btn-primary">Ajouter un utilisateur</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.user_id}</td>
                                    <td>${user.user_name}</td>
                                    <td class="actions">
                                        <a href="edit.htm?id=${user.user_id}" class="btn btn-primary">Modifier</a>
                                        <a href="delete.htm?id=${user.user_id}" 
                                           class="btn btn-danger"
                                           onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet utilisateur ?')">
                                           Supprimer
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>