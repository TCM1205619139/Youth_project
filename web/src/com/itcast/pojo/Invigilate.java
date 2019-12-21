package com.itcast.pojo;

import java.sql.Date;

public class Invigilate {
	private int invigilateid;
	private int id;
	private String subject;
	private Date time;
	private String place;
	private String classes;
	private String duration_time;
	private String invigilator;
	private String describe;
	public int getInvigilateid() {
		return invigilateid;
	}
	public void setInvigilateid(int invigilateid) {
		this.invigilateid = invigilateid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getDuration_time() {
		return duration_time;
	}
	public void setDuration_time(String duration_time) {
		this.duration_time = duration_time;
	}
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "invigilate [invigilateid=" + invigilateid + ", id=" + id + ", subject=" + subject + ", time=" + time
				+ ", place=" + place + ", classes=" + classes + ", duration_time=" + duration_time + ", invigilator="
				+ invigilator + ", describe=" + describe + "]";
	}
}
