package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.ClassroomUser;

public interface IClassroomService {

	public void saveUser(ClassroomUser classroomUser, String SubjectCode, String studentdept, String studentsection) throws SQLException;
    public List<ClassroomUser> getAllClassroom() throws SQLException;
}
