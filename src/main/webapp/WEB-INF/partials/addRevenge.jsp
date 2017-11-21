	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
    <div class="container">

			<!--  Form add a new revenge -->
			
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0"> Weak people revenge 
          <strong> Don't be weak </strong>
        </h2>
        <hr class="divider">
        <form:form  action="/revenge/saveRevenge" modelAttribute="revengeModel" method="post">
          <div class="row">
            <div class="form-group col-lg-4">
              <label class="text-heading">Your Name</label>
              <form:input class="form-control"  type="text" path="seeker"/>
               <font color="red"><form:errors path="seeker"/></font>
            </div>
            <div class="form-group col-lg-4">
              <label class="text-heading"> Your Target</label>
              <form:input type="text" class="form-control" path="target"/>
              <font color="red"><form:errors path="target"/></font>
            </div>
            <div class="clearfix"></div>
            <div class="form-group col-lg-12">
              <label class="text-heading">Your Stroy</label>
              <form:textarea path="story" class="form-control" rows="6"></form:textarea>
               <font color="red"><form:errors path="story"/></font>
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
   