	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
    <div class="container">
    
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">Revenges 
          <strong>Wishes</strong>
        </h2>
        <hr class="divider">
        
      	 <div class="panel panel-default">
			 <div class="panel-heading">Revenges wishes</div>
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
    	<div class="container text-center">
	    			<nav aria-label="Page navigation example">
					  <ul class="pagination">
					  	<li class="page-item"><a class="page-link" href="/revenge/list?page=${previous }">Previous</a></li>
					  	<c:forEach items="${pages}" var="page">
					  	<li class="page-item"><a class="page-link" href="/revenge/list?page=${page }">${page}</a></li>
					  	</c:forEach>
					    <li class="page-item"><a class="page-link" href="/revenge/list?page=${next }"> Next </a></li>
	  
					  </ul>
	
					 
					</nav>
				
		</div>
				   
	</div>			
				  
		
       	
   

     
    </div>
    <!-- /.container -->
   