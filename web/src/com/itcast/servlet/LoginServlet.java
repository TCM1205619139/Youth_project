package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itcast.pojo.Userinfo;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Userinfo users = new Userinfo();
		users.setUsername(username);
		users.setPassword(password);
		
		Userinfo user = userService.login(users);
		if(user!=null){
			//session找id
			int id=user.getId();
			HttpSession hs=req.getSession();
			String sessionId = hs.getId();
			hs.setMaxInactiveInterval(60*60*24);
			hs.setAttribute("id",id);
			System.out.println(sessionId);
			System.out.println(users.toString());
			resp.sendRedirect("index.html");
		}else{
			resp.sendRedirect("index.jsp?error=1"); 
		}
	}
}