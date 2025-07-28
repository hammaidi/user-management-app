<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update un utilisateur</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css">
</head>


<body>
	<h2>Update un utilisateur</h2>
<div>
 <form action="${pageContext.request.contextPath}/users" method="post">
    <label for="name">Nom d'utilisateur :</label> 
    <input type="text" 	name="name" id="name" required placeholder="Nom d'utilisateur.."/>
    <label for="password">Mot de passe :</label> 
    <input type="password" name="password" id="password" required /> 
  <input type="submit" value="Update" />
  
   
  </form>
</div>


	
	<hr />

	<h3>Liste des utilisateurs :</h3>
	<ul>
		<c:forEach var="u" items="${messagerUsers}">
			<li>ID: ${u.id}, Nom: ${u.name}</li>
		</c:forEach>
	</ul>

</body>
</html>
