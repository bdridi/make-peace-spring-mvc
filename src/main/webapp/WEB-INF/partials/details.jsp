	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="container">
			<!--  Form add a new revenge -->
			
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0"> Revenge   
          <strong> Details </strong>
        </h2>
        <hr class="divider">
       		
       		<div class="panel panel-default">
       			<div class="panel-heading">
       				${ revenge.seeker }'s Story
       			</div>
       			<div class="panel-body">
       				<table class="table table-striped">
       				<tr>
       					<td><b>Seeker</b></td>
       					<td>${ revenge.seeker }</td>
       				</tr>
       				<tr>
       					<td><b>Target</b></td>
       					<td>${ revenge.target }</td>
       				</tr>
       				<tr>
       					<td><b>Story</b></td>
       					<td>${ revenge.story }</td>
       				</tr>
       				</table>       			
       			</div>
      		</div> <!-- end panel -->
       				
       				<h2> Advices :</h2>
       				
       				 <c:forEach items="${revenge.advices}" var="advice">
       				 	  	<ul class="media-list">
							  <li class="media">
							    <a class="pull-left" href="#">
							      <img class="media-object" src="http://via.placeholder.com/80x80">					      
							    </a>
							    <div class="media-body well">
							      <h4 class="media-heading"> ${advice.user.username }</h4>
							   	  ${advice.advice }	   
							    </div>
							  </li>					  
							</ul>
       				 </c:forEach>			     
      </div>
	
	
		<c:if test="${not empty msg}">
						<div class="alert alert-info">${msg}</div>
		</c:if>	
        <form  action="/revenge/saveAdvice" method="post">
          <div class="row">            
            <div class="clearfix"></div>
            <div class="form-group col-lg-12">
              <label class="text-heading"><h3> Try to convince ${revenge.seeker} to make PEACE   </h3></label>
              <textarea  name="advice" class="form-control" rows="6"></textarea>
            </div>
            <div class="form-group col-lg-12">   
              <input  name="revenge_id" class="form-control" type="hidden" value="${revenge.id }">
            </div>
            <div class="form-group col-lg-12">
              <button type="submit" class="btn btn-secondary">Submit</button>
            </div>
          </div>
        </form>
      </div>	
     
    </div>
    <!-- /.container -->
   