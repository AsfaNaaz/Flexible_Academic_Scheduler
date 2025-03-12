package com.scheduler.model;

import java.sql.Timestamp;

public class DaySchedule {
	private String dept;
	private String batch;
	private String day;
	private java.sql.Timestamp stime;
	private String teacher;
	private String subcode;
	private String subtype;
	private java.sql.Timestamp etime;

	public Timestamp getStime() {
		return stime;
	}

	public Timestamp getEtime() {
		return etime;
	}

	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}

	public void setStime(java.sql.Timestamp stime) {
		this.stime = stime;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	@Override
	public String toString() {
		return "DaySchedule [dept=" + dept + ", batch=" + batch + ", day=" + day + ", stime=" + stime + ", teacher="
				+ teacher + ", subcode=" + subcode + ", subtype=" + subtype + ", etime=" + etime + "]";
	}
	
}
