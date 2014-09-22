package org.nhnnext.dbAdv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;

@SuppressWarnings("serial")
public class FrontController extends HttpServlet {
	private String RedisKey = "URLShortener";
	
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
				Jedis jedis = new Jedis("10.73.45.56");
				long ShortenURL = jedis.hlen(RedisKey) + 1;
				jedis.hset(RedisKey, String.valueOf(ShortenURL), originURL);
				jedis.close();
				response.setContentType("application/json");
				
				//TODO Return Shorten URL
				out.print(ShortenURL);
				
			} else if (method == METHOD.GET) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} else {
			String ShortenURL = request.getRequestURI().substring(1);
			Jedis jedis = new Jedis("10.73.45.56");
			String result = jedis.hget(RedisKey, ShortenURL);
			jedis.close();
			
			if(result != null){
				response.sendRedirect("http://" + result);
			}else{
				response.sendRedirect("/index.jsp");
			}

		}
		
		System.out.println(uri);
	}
}
