<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png" /> <a id="fav" href="ShowFavorites">Favorites</a>
	<a id="movie" href="ShowMovieListCustomer">Movies</a> </header>
	<div class="cont">
		<h2>Favorites</h2>
		<table>
			<h3>
				<p id="para1">${msg }</p>
			</h3>
			<tr>
				<th class="titles">Title</th>
				<th class="gros">Gross ($)</th>
				<th class="cntr">Genre</th>
				<th class="centr"></th>
			</tr>
			<c:forEach items="${movieItemListCustomer }" var="movie">
				<tr>

					<td class="titles"><c:out value="${movie.title }"></c:out></td>
					<td class="gros"><c:out value="${movie.gross }"></c:out></td>
					<td class="cntr"><c:out value="${movie.genre}"></c:out></td>
					<td class="centr"><a
						href="RemoveFavorites?movieItemId=${movie.id }">Delete</a></td>

				</tr>
			</c:forEach>
			<tr>
				<th class="titles"><p>No. of Favorites: 2</p></th>

			</tr>
		</table>
	</div>
	<footer> <span>Copyright@2019</span> </footer>
</body>
</html>
