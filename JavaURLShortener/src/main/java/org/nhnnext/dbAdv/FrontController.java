package org.nhnnext.dbAdv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FrontController extends HttpServlet {
	
	ArrayList<String> excludeList = new ArrayList<String>(Arrays.asList("/favicon.ico"));
	enum METHOD {
		GET,
		POST,
		PUT,
		DELETE,
		TRACE
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	
	public void requestHandler(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI();
		METHOD method = METHOD.valueOf(request.getMethod());
		PrintWriter out = response.getWriter();
		
		
		//Exclude URL Request (Instance Variable Declation List)
		if (excludeList.contains(uri)) {
			out.println("<script>alert('test');window.location='/'</script>");
			
			
		//Ajax Request For URL Shorten
		} else if (uri.equalsIgnoreCase("/")) {
			System.out.println("Ajax Request For URL Shorten");
			
			if (method == METHOD.POST) {
				
				String originURL = request.getParameter("originURL");
				
				//TODO InsertRequest
				System.out.println(originURL);
				
				response.setContentType("application/json");
				
				//TODO Return Shorten URL
				out.print(originURL);
				
			} else if (method == METHOD.GET) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		//Not Constructed URL Request
		} else {
			
			//TODO URL을 데이터베이스에서 가져온다. 해당 URL로 리다이렉트 시킨다
			
			//TODO 만약 데이터베이스에 존재하지 않는 URL일경우 
			//잘못된 URL이라는 에러메세지를 보여주고 
			//ROOT Path로 리다이렉트 시켜준다
		}
		
		System.out.println(uri);
	}
}
