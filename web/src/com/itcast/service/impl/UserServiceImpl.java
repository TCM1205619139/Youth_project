package com.itcast.service.impl;

import java.util.List;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;
import com.itcast.pojo.Userinfo;
import com.itcast.service.UserService;

public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	//userinfo
	public Userinfo login(Userinfo user) {
		return userMapper.selByUserPwd(user);
	}
	public String selusername(String username) {
		return userMapper.selByUser(username);
	}
	public int insUserinfo(Userinfo users) {
        return userMapper.insUserinfos(users);
    }
	
	//user
	public List<User> show() {
		return userMapper.selAll();
	}
	public User seluserByid(int id) {
		return userMapper.seluserByid(id);
	}
	public int insRegister(User users) {
        return userMapper.insUsers(users);
    }
	public int delRegister(int id) {
        return userMapper.removeUser(id);
    }
	public void modifyUser(User users) {
		userMapper.modifyUser(users);
    }
}
