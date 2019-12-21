package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itcast.pojo.Userinfo;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Userinfo users = new Userinfo();
		users.setUsername(username);
		users.setPassword(password);
		String user = userService.selusername(username);
		System.out.println(username);
		System.out.println(user);
		if(user==null){
			int i=userService.insUserinfo(users);
			System.out.println(i);
			resp.sendRedirect("index.jsp");
		}else{
			resp.sendRedirect("index.jsp?error=2"); 
		}
	}
}
