	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <div class="container">

      <div class="bg-faded p-4 my-4">
        <!-- Image Carousel -->
       
        <!-- Welcome Message -->
       
        <div class="text-center mt-4">
          <div class="text-heading text-muted text-lg">Welcome</div>
          <h1 class="my-2"> Living well is the best revenge. </h1>
          <div class="text-heading text-muted text-lg">By
            <strong>bdridi </strong>
          </div>
        </div>
      </div>
	
      <div class="container">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Recent Revenges 
          <strong>Wishes</strong>
        </h2>
        
        
        <hr class="divider">
        
      
        
       	 <div class="panel panel-default">
			 <div class="panel-heading">Recent wishes</div>
			<div class="panel-body">
				<table class="table">
		       	 		<tr>		 
			       	 		<th>Seeker</th>
			       	 		<th>Story</th>
			       	 		<th>Target</th>
			       	 		<th>Actions</th>
		       	 		</tr>
		 
					    <c:forEach items="${revenges.content}" var="revenge">
					        <tr>					       
					            <td> ${revenge.seeker}</td>  
					            <td> ${revenge.story}</td>  
					            <td> ${revenge.target}</td>  
					            <td> <a href="/revenge/details?id=${ revenge.id }"> <button class="btn btn-info"> More </button></a>
					        </tr>
					   </c:forEach>
    			</table>
			</div>				  
		</div>
       	
      </div>

     
    </div>
    <!-- /.container -->
    
   
   