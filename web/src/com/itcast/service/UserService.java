package com.itcast.service;

import java.util.List;
import com.itcast.pojo.User;
import com.itcast.pojo.Userinfo;

public interface UserService {
	/**
	 * 登录
	 * @param users
	 * @return
	 */
	Userinfo login(Userinfo user);
	int insUserinfo(Userinfo users);
	String selusername(String username);
	List<User> show();
	User seluserByid(int id);
	int insRegister(User users);
	void modifyUser(User users);
}
