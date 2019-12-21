package com.itcast.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.pojo.User;
import com.itcast.pojo.Userinfo;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext 默认去classes文件夹根目录开始寻找
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[] names = ac.getBeanDefinitionNames();
//		for (String string : names) {
//			System.out.println(string);
//		}
		UserServiceImpl bean = ac.getBean("userService",UserServiceImpl.class);
		
//		Userinfo aa=new Userinfo();
//		aa.setUsername("jw");
//		aa.setPassword("123");
//		Userinfo i=bean.login(aa);
//		System.out.println(i+"5s");
		
//		Userinfo aa=new Userinfo();
//		aa.setUsername("jssssa1");
//		aa.setPassword("123");
//		String user = bean.selusername("jssssa1");
//		System.out.println(user);
//		if(user==null){
//			int i=bean.insUserinfo(aa);
//			System.out.println(i);
//		}else{
//			System.out.println("有了");
//		}
		
		
//		User aa=new User();
//		aa.setName("yy");
//		aa.setSex("女");
//		aa.setAge(15);
//		aa.setPhone(1261);
//		int i=bean.insRegister(aa);
//		System.out.println(i);
		
//		int i=5;
//		int j=bean.delRegister(i);
//		System.out.println(j);
		
		String str = "2012-11-21";
	    java.sql.Date sqlDate = java.sql.Date.valueOf(str);
        System.out.println(sqlDate);
		User aa=new User();
		aa.setName("xx");
		aa.setNickname("cad");
		aa.setEmail(null);
		aa.setAddress(null);
		aa.setGender("男");
		aa.setPhone(618200);
		aa.setBirth(sqlDate);
		bean.modifyUser(aa);
		
		
//		User a=bean.seluserByid(2);
//		System.out.println(a.toString());
		
		List<User> list = bean.show();
		System.out.println(list);
		
//		JSONArray fromObject1 = JSONArray.fromObject(list);
//		String str1 = fromObject1.toString();
//		System.out.println(str1);
		JSONObject json= new JSONObject();
		json.put("nikename", aa.getNickname());
        json.put("tel", aa.getPhone());
        json.put("name", aa.getName());
        json.put("gender", aa.getGender());
        json.put("email", aa.getEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String dateStr = sdf.format(aa.getBirth());
        json.put("birth", dateStr);
        json.put("addr", aa.getAddress());
        System.out.println(json.toString());
	}
}
