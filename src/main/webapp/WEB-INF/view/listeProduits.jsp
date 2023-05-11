<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Produits</title>
</head>
<body>
	<h1>Liste des Produits</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Nom Produit</th>
			<th>Prix</th>
			<th>Date Création</th>
		</tr>
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.idProduit }</td>
				<td>${p.nomProduit }</td>
				<td>${p.prixProduit }</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${p.dateCreation}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>