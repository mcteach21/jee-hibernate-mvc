package mc.com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/front" })
public class FrontController extends Controller {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

//		if(request.getParameter("c")!=null) {
//			log.info("redirect to controller.."+request.getParameter("c"));
//			String  page = request.getParameter("page");
//			
//			response.sendRedirect("/test");
//			return;
//		}
		
		
		
		log.info("get..");
		infosFromRoute(request);
		logIt();
		
		if("test".equalsIgnoreCase(page)) {
			log.info("page..test!");
			ViewModel viewmodel = TestController.doGet();
			
			request.setAttribute("message", viewmodel.data);
			display(VIEW_FOLDER+viewmodel.view+".jsp", request, response);
			return;
		}
				
		if(!ViewExists(view))	
			setErrorView(request);					

		display(view, request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("post..");
		infosFromRoute(request);
		
		logIt();
		getParameters(request);	
		if("login".equals(page))
			log.info("login submit : "+request.getParameter("login"));
		
			//response.sendRedirect(request.getServletContext().getContextPath()+"/login");   		
	}
}
