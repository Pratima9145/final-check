<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript" /></script>
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png" /> <a id="movie" href="ShowMovieListAdmin">Movies</a>
	</header>
	
	
	<div class="cont">
		<h2>Edit Movie</h2>
		<form name="movieform" method="post"
			action="EditMovie?movieItemId=${movieItem.id }"
			onSubmit="return validation()">

			<table>
				<tr>
					<td colspan="4"><label for="title">Title</label></td>
				</tr>
				<tr>
					<td colspan="4"><input class="tbox" type="text" id="title"
						name="txtTitle" value="${movieItem.title }" /></td>
				</tr>
				<tr>
					<td><label for="gross">Gross ($)</label></td>
					<td><label for="Active">Active</label></td>
					<td><label for="launch">Date of Launch</label></td>
					<td><label for="Genre">Genre</label></td>
				</tr>
				<tr>
					<td><input class="grs" type="text" id="gross" name="txtGross"
						value="${movieItem.gross }" /></td>
					<td><input type="radio" id="rd1" name="rd3" value="Yes"
						<c:if test="${movieItem.active eq 'true' }">Checked</c:if>>
						<label for="rd1">Yes</label> <input type="radio" id="rd2"
						name="rd3" value="No"
						<c:if test="${movieItem.active eq 'false' }"></c:if>> <label
						for="rd2">No</label></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${movieItem.dateOfLaunch }" var="formatDate" /> <input
						type="text" id="launch" name="dateOfLaunch" value="${formatDate }" /></td>

					<td><select name="genres">
							<option value="${movieItem.genre }">${movieItem.genre}</option>
							<option value="science">Science Fiction</option>
							<option value="super">Superhero</option>
							<option value="roman">Romance</option>
							<option value="cmdy">Comedy</option>
							<option value="advent">Adventure</option>
							<option value="thrill">Thriller</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" id="check1"
						name="check" 
						<c:if test="${movieItem.hasTeaser eq 'true'}">Checked</c:if>
						<c:if test="${movieItem.hasTeaser eq 'false'}"></c:if>> <label
						for="check1">Has Teaser</label></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn" type="Submit" name="Submit"
						value="Save" onClick="validate" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>

