package com.itcast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.itcast.pojo.User;
import com.itcast.pojo.Userinfo;

public interface UserMapper {
	//userinfo
	@Select("select * from userinfo where username=#{username} and password=#{password}")
	Userinfo selByUserPwd(Userinfo user);
	
	@Select("select * from userinfo where username=#{username}")
	String selByUser(String username);
	
	@Insert("insert into userinfo values (default,#{username},#{password})")
    int insUserinfos(Userinfo user);
	
	//user
	@Select("select * from user ")
	List<User> selAll();
	
	@Select("select * from user where id=#{id}")
	User seluserByid(int id);
	
	@Insert("insert into user values (default,#{name},#{nickname},#{email},#{address},#{birth},#{phone})")
    int insUsers(User user);
	
	@Delete("delete from user where id=#{id}")
    int removeUser(@Param("id") Integer id);
	
	@Update("update user set name=#{name},nickname=#{nickname},email=#{email},address=#{address},birth=#{birth},gender=#{gender},phone=#{phone} where id=#{id}")
    void modifyUser(User user);
}
