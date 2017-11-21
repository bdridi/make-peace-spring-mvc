<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
</script>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
 
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/revenge/home"> Let's make peace !</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/revenge/home">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="/revenge/add"> Your Story </a></li>
        <li><a href="/revenge/list">People's stories</a></li>
         <li><a href="/revenge/contact">Contact us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:choose>
   	  	<c:when test="${pageContext.request.userPrincipal.name != null}">
   	  		<li>Welcome : ${pageContext.request.userPrincipal.name}</li> 	  		
   	  		<li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Profil</a></li>
	            <li><a href="javascript:formSubmit()">Logout</a></li>        
	          </ul>
       		</li>
        </c:when>
        <c:otherwise>
        	<li><a href="/revenge/login">Sign-in</a></li>
            <li><a href="/revenge/signup">Sign-up</a></li>
        </c:otherwise>	
       </c:choose>
      </ul>
    </div>
  </div><
</nav>
 
 <div class="container">
  <div class="page-header">
  <h1 class="text-shadow">Let's make peace ! <small>Tis more noble to forgive, and more manly to despise, than to revenge an Injury.</small></h1>
</div>
 
 </div>

