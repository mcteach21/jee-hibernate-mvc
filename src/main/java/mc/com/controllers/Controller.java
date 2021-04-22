package mc.com.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected static final long serialVersionUID = 10000L;

	protected static Logger log=Logger.getLogger(FrontController.class);
	protected static final String SHARED_FOLDER = "/WEB-INF/views/shared/";
	protected static final String VIEW_FOLDER = "/WEB-INF/views/";
	protected static final String UPLOAD_FOLDER = "/WEB-INF/views/uploads/";
	protected static final String MAIN_VIEW = "front";	
	protected String page,view,action;


	protected void setErrorView(HttpServletRequest request) {
		request.setAttribute("error", "404");
		request.setAttribute("message", page+"Not Found!");
	}
	protected void infosFromRoute(HttpServletRequest request) {
		page=request.getParameter("page");
		view = getViewFromRoute(request);
		action = getActionFromRoute(request);
	}
	protected void logIt() {
		log.info("***************************************************************");
		log.info("Servlet (Main) ==> Page from route = "+page);
		log.info("Servlet (Main) ==> View to display = "+view);
		log.info("Servlet (Main) ==> Action = "+action);
		log.info("***************************************************************");
	}	
	protected String getViewFromRoute(HttpServletRequest request) {
		String page="";
		//		if(request.getParameter("category")!=null) {
		//			page  = VIEW_FOLDER+request.getParameter("category");
		//			page += (request.getParameter("page")!=null)?"/"+request.getParameter("page"):"/index";
		//		}else {

		page = (request.getParameter("page")!=null)?VIEW_FOLDER+request.getParameter("page"):VIEW_FOLDER+MAIN_VIEW;
		return page+".jsp";
	}
	protected String getActionFromRoute(HttpServletRequest request) {
		return (request.getParameter("action")!=null)?VIEW_FOLDER+request.getParameter("action"):"";
	}
	protected boolean ViewExists(String page) {
		String fullPath = this.getServletContext().getRealPath(page);
		try {
			File fview=new File(fullPath);
			//			log.info("***************************************************************");
			//			log.log(Level.INFO, "File (View) :"+fview.exists()+" "+fview.getAbsolutePath());
			//			log.log(Level.INFO, page+ " fullPath : "+fullPath);
			//			log.info("***************************************************************");	
			return fview.exists();
		} catch (Exception e) {			
			log.info("***************************************************************");
			log.log(Level.ERROR, e.getMessage());
			log.info("***************************************************************");
		}

		return false;
	}
	protected void display(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		viewName = viewName.replace(VIEW_FOLDER, "");
		request.setAttribute("title", viewName.replace(".jsp", ""));
		request.setAttribute("page", viewName);	

		String view_to_display=SHARED_FOLDER+"layout.jsp";	
		request.getRequestDispatcher(view_to_display).forward(request, response);		
	}

	protected void getParameters(HttpServletRequest request) {
		if(request.getParameterMap().size()==0) {
			System.out.println("Front Controller : No Parameters!");
			return;
		}

		System.out.println("**********************************");
		System.out.println("******* Front - Parameters *******");
		Map<String, String[]> params = request.getParameterMap();
		StringBuffer sb= new StringBuffer();
		for(Map.Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			System.out.println(key+" ==> "+Arrays.deepToString(values));

			sb.append(key+" ==> "+Arrays.deepToString(values)+"\n");
		}
		//request.setAttribute("message",sb.toString());
		log.info(sb.toString());
		System.out.println("**********************************");
	}
}
