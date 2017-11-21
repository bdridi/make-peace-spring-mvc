<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">		
			<div class="panel panel-default">
				<div class="panel-heading">
					Please enter your username and password..
				</div>				
				<div class="panel-body">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>	
					<c:if test="${not empty msg}">
						<div class="alert alert-info">${msg}</div>
					</c:if>	
					<form name='loginForm'
					  action="<c:url value='/j_spring_security_check' />" method='POST'>
						<div class="form-group">
							<label>Username </label>
							<input type='text' class="form-control" name='username'>
						</div>					
						<div class="form-group">
							<label>Password</label>
							<input type='password' class="form-control" name='password' />
						</div>
						
						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<div class="form-group">					
							  	<input name="submit" class="form-control btn btn-disabled" type="button"
							 	 value="submit" />
						</div>	  				
						</c:if>	
						
						<c:if test="${pageContext.request.userPrincipal.name == null}">
							<div class="form-group">
								<input name="submit" class="form-control btn btn-primary" type="submit"
								  value="submit" />
							  
							</div>	  				
						</c:if>						
								
					  	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />			
					</form>		
				</div> <!-- end panel body -->
			</div> <!-- end panel -->
		</div>	<!-- end col-md-4 -->		
	</div>	<!-- end row -->
</div> <!-- end container -->

