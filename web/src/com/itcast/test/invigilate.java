package com.itcast.test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.pojo.Invigilate;
import com.itcast.pojo.Meeting;
import com.itcast.service.impl.InvigilateServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class invigilate {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		InvigilateServiceImpl bean = ac.getBean("invigilateService",InvigilateServiceImpl.class);
		
//		String str = "2012-11-21";
//	    java.sql.Date sqlDate = java.sql.Date.valueOf(str);
//	    System.out.println(sqlDate);
//	    Invigilate m=new Invigilate();
//	    m.setId(1);
//	    m.setSubject("java");
//	    //m.setTime(sqlDate);
//	    m.setPlace("5401教室");
//	    m.setClasses("175");
//	    m.setDuration_time("120分钟");
//	    m.setInvigilator("老师");
//	    m.setDescribe("描述一些");
//		bean.insInvigilate(m);
		
		int i=1;
		List<Invigilate> list = bean.selinvigilateByid(i);
		System.out.println(list.get(1));
		System.out.println(list.get(0));
		
		JSONArray employees = new JSONArray();      //JSON数组
        JSONObject employee = new JSONObject();     //JSON对象
		for(int j=0;j<list.size();j++)
		{
			employee.put("subject", list.get(j).getSubject());
			employee.put("place", list.get(j).getPlace());
			employee.put("class", list.get(j).getClass());
			employee.put("duration_time", list.get(j).getDuration_time());
			employee.put("invigilator", list.get(j).getInvigilator());
			employee.put("describe", list.get(j).getDescribe());
			employees.add(employee);
		}
		System.out.println(employees.toString());

	}
}
