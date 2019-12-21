package com.itcast.test;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.pojo.Meeting;
import com.itcast.pojo.User;
import com.itcast.service.impl.MeetingServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class meeting {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		MeetingServiceImpl bean = ac.getBean("meetingService",MeetingServiceImpl.class);
		
//		String str = "2012-11-21";
//	    java.sql.Date sqlDate = java.sql.Date.valueOf(str);
//        System.out.println(sqlDate);
//		Meeting m=new Meeting();
//		m.setId(1);
//		m.setTheme("工程实践3");
//		m.setPlace("5405");
//		m.setContent("无");
//		m.setOther("1?");
//		m.setTime(sqlDate);
//		bean.insMeeting(m);
		
//		int i=13;
//		System.out.println(bean.delmeeting(i));
		
		JSONArray employees = new JSONArray();      //JSON数组
        JSONObject employee = new JSONObject();     //JSON对象
		int i=1;
		List<Meeting> list = bean.selByid(1);
		System.out.println(list);
		for(int j=0;j<list.size();j++)
		{
			employee.put("theme", list.get(j).getTheme());
			employee.put("place", list.get(j).getPlace());
			employee.put("content", list.get(j).getContent());
			employee.put("other", list.get(j).getOther());
			Date date=list.get(j).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			employee.put("time",dateString);
			employees.add(employee);
			System.out.println(employees.toString());
			System.out.println(formatter.format(new Date()));
			String now=formatter.format(new Date());
			Date sqlDate = java.sql.Date.valueOf(now);
	        System.out.println(now);// new Date()为获取当前系统时间
	        if(date.getTime()>sqlDate.getTime())//比较时间大小,如果dt1大于dt2
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");//运行输出no
			}
		}
		
		
//		JSONArray js = bean.showsm();
//		System.out.println(js.toString());
		
//		List<Meeting> list2 = bean.selBymeetingid(i);
//		System.out.println(list2);
	}
}
