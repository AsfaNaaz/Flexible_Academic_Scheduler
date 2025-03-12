package com.scheduler.model;

import java.util.List;

public class DayTimeTable {
	private int weekday;
	private List<SubjectSchedule> subjects;
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public List<SubjectSchedule> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectSchedule> subjects) {
		this.subjects = subjects;
	}
	
	
}
