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
import java.sql.Date;
import com.itcast.pojo.Invigilate;
import com.itcast.service.InvigilateService;
import com.itcast.service.impl.InvigilateServiceImpl;

@WebServlet("/task_management/invigilate")
public class InsInvigilateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InvigilateService invigilateService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		invigilateService=ac.getBean("invigilateService",InvigilateServiceImpl.class);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		String sessionId = hs.getId();
		System.out.println("sessionId:"+sessionId);
		int id=(int) hs.getAttribute("id");
		System.out.println("id="+id);
		Invigilate m=new Invigilate();
		m.setId(id);
//		String str =req.getParameter("time");
		String str = "2012-11-21";
	    Date sqlDate = java.sql.Date.valueOf(str);
	    System.out.println(sqlDate);
		m.setTime(sqlDate);
		m.setSubject(req.getParameter("subject"));
		m.setPlace(req.getParameter("place"));
		m.setDuration_time(req.getParameter("duration_time"));
		m.setClasses(req.getParameter("class"));
		m.setInvigilator(req.getParameter("invigilator"));
		m.setDescribe(req.getParameter("describe"));
		System.out.println(m.toString());
		invigilateService.insInvigilate(m);
		
	}
}
