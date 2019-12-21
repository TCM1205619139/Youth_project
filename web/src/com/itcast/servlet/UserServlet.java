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
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itcast.pojo.User;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		String sessionId = hs.getId();
		System.out.println("sessionId:"+sessionId);
		int id=(int) hs.getAttribute("id");
		System.out.println("id="+id);
		User users = new User();
		users.setId(id);
		users.setAddress(req.getParameter("addr"));
		System.out.println(req.getParameter("birth"+"-----454"));
		String birth=req.getParameter("birth");
		java.sql.Date date = java.sql.Date.valueOf(birth);
        System.out.println(date);
		users.setBirth(date);
		users.setEmail(req.getParameter("email"));
		users.setGender(req.getParameter("gender"));
		users.setName(req.getParameter("name"));
		users.setNickname(req.getParameter("nikename"));
		String tel=req.getParameter("tel");
		int phone=Integer.parseInt(tel);
		users.setPhone(phone);
		System.out.println(users.toString());
		userService.modifyUser(users);
	}
}
