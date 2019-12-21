package com.itcast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itcast.pojo.Invigilate;

public interface InvigilateMapper {
	//某个人的
		@Select("select * from invigilate where id=#{id}")
		List<Invigilate> selinvigilateByid(int id);
		//某个会议
		@Select("select * from invigilate where invigilateid=#{invigilateid}")
		List<Invigilate> selByinvigilateid(int invigilateid);
		
		@Insert("insert into invigilate values (default,#{id},#{subject},#{time},#{place},#{classes},#{duration_time},#{invigilator},#{describe})")
	    int insMeeting(Invigilate invigilate);
		
		//
		@Select("select * from invigilate ")
		List<Invigilate> selAll();
}
