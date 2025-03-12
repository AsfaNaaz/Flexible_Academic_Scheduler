package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.SubjectUser;
import com.scheduler.model.TeacherUser;

public interface ISubjectService {
	public void saveUser(SubjectUser subjectUser,String teacherId) throws SQLException;
	public List<SubjectUser> getAllSubject() throws SQLException;
	

}
