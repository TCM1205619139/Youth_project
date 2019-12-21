package com.itcast.test;

import net.sf.json.JSONArray;

import com.itcast.pojo.Userinfo;
public class Jsonlib {
	public static void main(String[] args) {
		Userinfo user1 = new Userinfo();
		user1.setUsername("111");
		user1.setPassword("111");

		JSONArray fromObject1 = JSONArray.fromObject(user1);

		String str1 = fromObject1.toString();
		System.out.println(str1);
	}
}
