<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<style>

.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

.rotate90 {
    -webkit-transform: rotate(90deg);
    -moz-transform: rotate(90deg);
    -o-transform: rotate(90deg);
    -ms-transform: rotate(90deg);
    transform: rotate(90deg);
}
</style>

<body>

	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Friends Suggester</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
 <div class="dropdown">
  <button class="dropbtn" >Select Here</button>
  <div class="dropdown-content">
    <a href="/">Individual Upload</a>
    <a href="/group">Group Upload</a>
    <a href="/readallname">Suggest Friends</a>
  </div>
</div>


		</div>
		
	</div>
	</nav>
	<div>
	<c:choose>
	 <c:when test="${firstName == 'Senthil' || secondName == 'Senthil'}">
	 	<h2 align="center"> ${firstName} can be friend with ${secondName}</h2>
	 </c:when>
	  <c:otherwise>
	    	<h2 align="center">Invalid Data. Please check your administrator ! ! !</h2>
	  </c:otherwise>
	 </c:choose>
	 
	 <c:if test="${firstName == 'Senthil' || secondName == 'Senthil'}">
	 <div align="center"> <img src="../image/senthil.jpg" width="200" height="200" class="rotate90"/></div>
	 </c:if>
	 
	  <c:if test="${firstName == 'Praveen' || secondName == 'Praveen'}">
	 <div align="center"> <img src="../image/praveen.jpg" width="200" height="200" class="rotate90"/></div>
	 </c:if>
	 
	  <c:if test="${firstName == 'Vinoth' || secondName == 'Vinoth'}">
	 <div align="center"> <img src="../image/vinoth.jpg" width="200" height="200" class="rotate90"/></div> 
	 </c:if>
	 
	
	

</div>
	
</body>
</html>