<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png" /> <a id="movie" href="ShowMovieListAdmin">Movies</a>
	</header>
	<div class="cont">
		<h2>Edit Movie Status</h2>
		<table>
			<tr>
				<td>
					<h3>
						<p id="para">${msg }</p>
					</h3>
				</td>
			</tr>
		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>