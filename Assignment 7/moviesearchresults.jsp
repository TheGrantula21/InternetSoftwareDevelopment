<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import= "edu.txstate.internet.cyberflix.*"%>
<%@ page import= "edu.txstate.internet.cyberflix.utils.MovieImageHandler" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

	.details{
		
		position: relative;
		padding-left: 145px;
	
	}
	
	




</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Results Page</title>
</head>
<body>

	
	
	
			<h1>Movies Matching Your Search</h1>
			<hr>
			
		
		
		
		
		
			<c:forEach items="${films}" var="film">
			<c:set var = "ID"  value = "${film.filmID}"/>
			
			
			<form action="http://localhost:8080/CyberFlix0/CyberFlixMovieDetailServlet" method="get">
			<%
			
			 
			MovieImageHandler movies = new MovieImageHandler();
			
			String path = "img/" + movies.nextMovieTitle();
			
			
			
			String value = Integer.toString((int)pageContext.getAttribute("ID"));
			
			
			
			
			
			
			out.print("<input type= 'image' src="+path+" name='film_id'   />");
			out.print("<input type='hidden' name='film_id' value= "+value+"   />");
			out.print(value);
			
  			
			%>
			
			
			
  			
  			
  			<div class="details">
  			<c:out value="${film.title}" />
  			<br>
  			<br>
  			<br>
  			
  			 
  			<strong>Year: </strong> <c:out value="${film.releaseYear}" />
  			
  			<br>
  			<br>
  			<br>
  			
  			<strong>Rating:</strong> <c:out value="${film.rating}" />
  			<br>
  			<br>
  			<br>
  			<strong>Runtime:</strong> <c:out value="${film.length}" /> minutes
  			</div>
  			<br>
  			<br>
  			<br>
  			<c:out value="${film.description}" />
  			<br>
  			<hr>
  			
  			</form>
  			
  			
  			
  		
			</c:forEach>
		
	
	
	
	
	
	
	


</body>
</html>