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
		<h2>Movies</h2>
		<table class="table">
			<p id="para1">${addFavoritesStatus }</p>
			<tr>
				<th class="titles">Title</th>
				<th class="gros">Gross ($)</th>
				<th class="cntr">Genre</th>
				<th class="cntr">Has Teaser</th>
				<th class="centr">Action</th>
			</tr>

			<c:forEach items="${movieItemList }" var="movie">
				<tr>

					<td class="titles"><c:out value="${movie.title }"></c:out></td>
					<td class="gros"><c:out value="${movie.gross }"></c:out></td>
					<td class="cntr"><c:out value="${movie.genre}"></c:out></td>

					<td class="cntr"><c:if test="${movie.hasTeaser }">Yes</c:if> <c:if
							test="${!movie.hasTeaser }">No</c:if></td>


					<td class="centr"><a
						href="AddToFavorites?movieItemId=${movie.id }">Add to Favorite</a></td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<footer> <span>Copyright@2019</span> </footer>
</body>
</html>