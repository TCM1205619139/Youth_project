package com.itcast.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/task_management/seldoingmeetingbyid")
public class SeldoneMeetingServlet extends HttpServlet{
	private MeetingService meetingService;
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		meetingService=ac.getBean("meetingService",MeetingServiceImpl.class);
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession hs=req.getSession();
		String sessionId = hs.getId();
		System.out.println(sessionId);
		int id=(int) hs.getAttribute("id");
		System.out.println(id+"--");
		List<Meeting> list = meetingService.selByid(id);
		System.out.println(list);
		JSONArray employees = new JSONArray();      //JSON数组
        JSONObject employee = new JSONObject();     //JSON对象
        System.out.println(list);
		for(int j=0;j<list.size();j++)
		{
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(date);
			String now=formatter.format(new Date());
			Date sqlDate = java.sql.Date.valueOf(now);
	        System.out.println(now);// new Date()为获取当前系统时间
	        if(date.getTime()>sqlDate.getTime())//比较时间大小,如果dt1大于dt2
			{
	        	employee.put("meetingid", list.get(j).getMeetingid());
	        	employee.put("time",dateString);
	        	employee.put("theme", list.get(j).getTheme());
				employee.put("place", list.get(j).getPlace());
				employee.put("content", list.get(j).getContent());
				employee.put("other", list.get(j).getOther());
				employees.add(employee);
				System.out.println(employees.toString());
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");//运行输出no
			}
		}
		System.out.println(employees.toString());
		resp.setContentType("text/html;charset=utf-8"); 
	    resp.getWriter().print(employees);
	}
}