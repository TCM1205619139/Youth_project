package com.itcast.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

@WebServlet("/task_management/as")
public class TestServlet extends HttpServlet{

	private UserService userService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("jianc");
		System.out.println(req.getParameter("theme"));
		System.out.println(req.getParameter("place"));
	}
	
}
