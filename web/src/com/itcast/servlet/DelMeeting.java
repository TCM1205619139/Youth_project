package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itcast.pojo.Meeting;
import com.itcast.service.MeetingService;
import com.itcast.service.impl.MeetingServiceImpl;

@WebServlet("/task_management/delmeeting")
public class DelMeeting extends HttpServlet{
	private MeetingService meetingService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		meetingService=ac.getBean("meetingService",MeetingServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("task_id")+"555");
		int meetingid=Integer.parseInt(req.getParameter("task_id"));
		System.out.println(meetingService.delmeeting(meetingid));
	}
}
