package com.itcast.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import net.sf.json.JSONObject;

@WebServlet("/users")
public class SeluserServlet extends HttpServlet {
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac  = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService=ac.getBean("userService",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("das");
		HttpSession hs=req.getSession();
		String sessionId = hs.getId();
		System.out.println(sessionId);
		int id=(int) hs.getAttribute("id");
		System.out.println(id+"--");
		User a=userService.seluserByid(id);
		System.out.println(a.toString());
		
		JSONObject json= new JSONObject();
		json.put("nikename", a.getNickname());
        json.put("tel", a.getPhone());
        json.put("name", a.getName());
        json.put("gender", a.getGender());
        json.put("email", a.getEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(a.getBirth());
        json.put("birth", dateStr);
        json.put("addr", a.getAddress());
        System.out.println(json.toString());
        resp.setContentType("text/html;charset=utf-8"); 
        resp.getWriter().print(json);
	}
}
