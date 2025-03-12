package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.TeacherUser;

public interface ITeacherService {
	public void saveUser(TeacherUser teacherUser) throws SQLException;

	public List<TeacherUser> getAllTeacher() throws SQLException;

}
