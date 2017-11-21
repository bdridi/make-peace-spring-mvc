	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
    <div class="container">

			<!--  Form add a new revenge -->
			
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0"> Sign Up !   
          <strong> !!!  </strong>
        </h2>
        <hr class="divider">
        <form:form  action="/revenge/saveUser" modelAttribute="userModel" method="post">
          <div class="row">
            <div class="form-group col-lg-12">
              <label class="text-heading">Name</label>
              <form:input class="form-control"  type="text" path="name"/>
               <font color="red"><form:errors path="name"/></font>
            </div>
             <div class="clearfix"></div>
             
            <div class="form-group col-lg-12">
              <label class="text-heading"> Username </label>
              <form:input type="text" class="form-control" path="username"/>
              <font color="red"><form:errors path="username"/></font>
            </div>
            
            <div class="clearfix"></div>  
                            
             <div class="form-group col-lg-12">
              <label class="text-heading"> Email address</label>
              <form:input type="email" class="form-control" path="email"/>
              <font color="red"><form:errors path="email"/></font>
            </div>
            
             <div class="clearfix"></div>  
                            
             <div class="form-group col-lg-12">
              <label class="text-heading"> Password </label>
              <form:input type="password" class="form-control" path="password"/>
              <font color="red"><form:errors path="email"/></font>
            </div>
            
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Submit</button>
            </div>
          </div>
        </form:form>
      </div>
       	
      </div>

     
    </div>
    <!-- /.container -->
   