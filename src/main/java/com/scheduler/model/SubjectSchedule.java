package com.scheduler.model;

public class SubjectSchedule {
	private String stime;
	private String etime;
	private String subcode;
	private String subtype;
	private String teacherid;
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
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
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	@Override
	public String toString() {
		return "SubjectSchedule [stime=" + stime + ", etime=" + etime + ", subcode=" + subcode + ", subtype=" + subtype
				+ ", teacherid=" + teacherid + "]";
	}
	
	

}
