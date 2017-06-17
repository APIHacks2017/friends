<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<%-- <link href="${jstlCss}" rel="stylesheet" /> --%>

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

	<div class="container">

		<div class="starter-template">
			<h1>Welcome to Friends Suggestor Using Image ! ! !</h1>
		</div>

	</div>
	<br/>
	<table style="width: 100px;">
	<tr>
	     <td>
     <form method="POST" action="/uploadpraveen" enctype="multipart/form-data">
	     	 <label>Praveen Photo Upload &nbsp;<input type="file" name="file" id="file" /></label>
	    	 <label><input type="submit" name="button" id="button" value="Submit" /></label>

</form>
</td>
 <td>
  <form method="POST" action="/uploadsenthil" enctype="multipart/form-data">
	     	 <label>Senthil Photo Upload &nbsp;<input type="file" name="file" id="file" /></label>
	    	 <label><input type="submit" name="button" id="button" value="Submit" /></label>
</form>
    </td>
     <td>
  <form method="POST" action="/uploadvinoth" enctype="multipart/form-data">
	     	 <label>Vinoth Photo Upload &nbsp;<input type="file" name="file" id="file" /></label>
	    	 <label><input type="submit" name="button" id="button" value="Submit" /></label>
 
</form>
 </td>
   </tr>
   <tr>
   <td>&nbsp;</td>
   </tr>
   <tr>
   <td>
     <form method="POST" action="/individualclear" enctype="multipart/form-data">
	    	 <label><input type="submit" name="button" id="button" value="Clear" /></label>
	    	

 
</form>
   </td> 
   </tr>
    </table>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
