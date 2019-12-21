package com.itcast.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.itcast.pojo.Meeting;

import net.sf.json.JSONArray;

public interface MeetingMapper {
	//某个人的
	@Select("select * from meeting where id=#{id}")
	List<Meeting> selByid(int id);
	//某个会议
	@Select("select * from meeting where meetingid=#{meetingid}")
	List<Meeting> selBymeetingid(int meetingid);
	
	
	@Insert("insert into meeting values (default,#{id},#{theme},#{time},#{place},#{content},#{other})")
    int insMeeting(Meeting meeting);
	
	@Select("select theme,time,place,content,other from meeting ")
	JSONArray sel();
	@Select("select theme,time,place,content,other from meeting ")
	List<Meeting> sel2();
	//
	@Select("select * from meeting ")
	List<Meeting> selAll();
	@Delete("delete from meeting where meetingid=#{meetingid}")
    int removeMeeting(Integer meetingid);
}
