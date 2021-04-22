<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="mc">

    <title>${title}</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
	
	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/assets/css/bootstrap/css/bootstrap.min.css" />		
    <link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/assets/css/template-style.css" />
	<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/assets/css/style.css" />	 
  </head>
  <body> 	
	<c:import url="components/menu.jsp"></c:import> 
    <header>
    	<c:if test="${page=='front.jsp'}">
			<c:import url="components/slider.jsp"></c:import>
		</c:if> 
    </header>
    <div class="container main-container">	     	
			<c:import url="components/info.jsp"></c:import>
			<hr />
		
			<c:set var="include_page" value='${error!=null?"error.jsp":page}' />
			<c:set var="prefix_dir" value='${error!=null?"":"../"}' />
			<c:import url="${prefix_dir}${include_page}" />
	     
	      <!-- Section 
	      <div class="row mb-4">
	        <div class="col-md-8">
	          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
	        </div>
	        <div class="col-md-4">
	          <a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
	        </div>
	      </div>
	      -->
    </div>
	<footer class="py-5 bg-dark footer">
      <div class="container00">
        <p class="m-0 text-center text-white">copyright &copy; MC. 2018-2019</p>
      </div>
    </footer>

<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	
	<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap/bootstrap.bundle.min.js"></script>
  </body>
</html>
