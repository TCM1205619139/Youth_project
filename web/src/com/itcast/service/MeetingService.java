package com.itcast.service;

import java.util.List;

import com.itcast.pojo.Meeting;

import net.sf.json.JSONArray;

public interface MeetingService {
	List<Meeting> selByid(int id);
	List<Meeting> selBymeetingid(int meetingid);
	int insMeeting(Meeting meeting);
	int delmeeting(int meetingid);
	List<Meeting> show();
	List<Meeting> show2();
	JSONArray showsm();
}
