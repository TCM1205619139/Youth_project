package com.itcast.pojo;

import java.sql.Date;

public class Meeting {
	private int meetingid;
	private int id;
	private String theme;
	private Date time;
	private String place;
	private String content;
	private String other;
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "Meeting [meetingid=" + meetingid + ", id=" + id + ", theme=" + theme + ", time=" + time + ", place="
				+ place + ", content=" + content + ", other=" + other + "]";
	}

}
