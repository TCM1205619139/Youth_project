package com.itcast.service.impl;

import java.util.List;

import com.itcast.mapper.MeetingMapper;
import com.itcast.pojo.Meeting;
import com.itcast.service.MeetingService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MeetingServiceImpl implements MeetingService {
	private MeetingMapper meetingMapper;

	public MeetingMapper getMeetingMapper() {
		return meetingMapper;
	}
	public void setMeetingMapper(MeetingMapper meetingMapper) {
		this.meetingMapper = meetingMapper;
	}
	
	public int delmeeting(int meetingid) {
        return meetingMapper.removeMeeting(meetingid);
    }
	public List<Meeting> selByid(int id) {
		return meetingMapper.selByid(id);
	}
	public List<Meeting> selBymeetingid(int meetingid) {
		return meetingMapper.selBymeetingid(meetingid);
	}
	public int insMeeting(Meeting meeting) {
        return meetingMapper.insMeeting(meeting);
    }
	public JSONArray showsm() {
		return meetingMapper.sel();
	}
	public List<Meeting> show() {
		return meetingMapper.selAll();
	}
	@Override
	public List<Meeting> show2() {
		return meetingMapper.sel2();
	}
}
