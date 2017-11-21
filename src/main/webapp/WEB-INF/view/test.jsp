<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped">
		       	 		<tr>		 
		       	 		<td>Seeker</td>
		       	 		<td>Story</td>
		       	 		<td>Target</td>
		       	 		<td>Actions</td>
		       	 		</tr>	      
		       	 		
					    <c:forEach items="${revenges.content}" var="revenge">
					        <tr>
					       
					            <td> ${revenge.seeker}</td>  
					            <td> ${revenge.story}</td>  
					            <td> ${revenge.target}</td>  
					            <td> <a href="/revenge/details/?id=${ revenge.id }"> <button> More </button></a>
					        </tr>
					   </c:forEach>
</table>
  
</body>
</html>