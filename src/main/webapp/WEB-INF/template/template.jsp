<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<!DOCTYPE HTML>
<html>
<head>

  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>${param.title}</title>

 <!--   Bootstrap core CSS   -->   
 <link href="vendor/bootstrap/css/bootstrap-3.3.7.css" rel="stylesheet"> 
    
	 
    <!-- Custom fonts for this template -->
    <!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
 -->	
    <!-- Custom styles for this template -->
    <link href="css/business-casual.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="/WEB-INF/partials/header.jsp"/>
	<jsp:include page="/WEB-INF/partials/${param.content}.jsp"/>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp"/>
	
	<script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap-3.3.7.js"></script>
   
	
</body>
</html>
