 <!-- Navigation -->
 
 <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
   <div class="container">
   
     <a class="navbar-brand" href="<%= request.getContextPath() %>/">
     	<img src="<%= request.getContextPath() %>/assets/images/duke-filled-48.png" alt="logo" />&nbsp;MC.
     </a>
          
     <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>
     <div class="collapse navbar-collapse" id="navbarResponsive">
       <ul class="navbar-nav ml-auto">
        
         <li class="nav-item">
           <a class="nav-link" href="<%= request.getContextPath() %>/posts">Main</a>
         </li>
         <li class="nav-item">
           <a class="nav-link" href="<%= request.getContextPath() %>/contact">Contact</a>
         </li>      
         <li class="nav-item">
           <a class="nav-link" href="<%= request.getContextPath() %>/about">About</a>
         </li>   
         <li class="nav-item"><a  href="#myModal" class="nav-link trigger-btn" data-toggle="modal">Login</a></li>
       </ul>
     </div>
   </div>
 </nav>

<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">Member Login</h4>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form action="<%= request.getContextPath() %>/login" method="post">
					<!-- <input type="hidden" name="page" value="login" /> -->
					<div class="form-group">
						<i class="fa fa-user"></i>
						<input type="text" class="form-control" name="login" placeholder="Username" required="required">
					</div>
					<div class="form-group">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" name="password" placeholder="Password" required="required">					
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block btn-lg" value="Login">
					</div>
				</form>				
				
			</div>
			<div class="modal-footer">
				<a href="#">Forgot Password?</a>
			</div>
		</div>
	</div>
</div>  
