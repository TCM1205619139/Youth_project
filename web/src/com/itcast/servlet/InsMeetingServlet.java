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

import com.itcast.pojo.Meeting;
import com.itcast.service.MeetingService;
import com.itcast.service.impl.MeetingServiceImpl;

@WebServlet("/task_management/insmeeting")
public class InsMeetingServlet extends HttpServlet{
	private MeetingService meetingService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		meetingService=ac.getBean("meetingService",MeetingServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		String sessionId = hs.getId();
		System.out.println("sessionId:"+sessionId);
		int id=(int) hs.getAttribute("id");
		System.out.println("id="+id);
		Meeting m=new Meeting();
		m.setId(id);
		String str =req.getParameter("time");
	    java.sql.Date sqlDate = java.sql.Date.valueOf(str);
	    System.out.println(sqlDate);
		m.setTime(sqlDate);
		m.setTheme(req.getParameter("theme"));
		m.setPlace(req.getParameter("place"));
		m.setContent(req.getParameter("content"));
		m.setOther(req.getParameter("other"));
		System.out.println(m.toString());
		meetingService.insMeeting(m);
	}
}
