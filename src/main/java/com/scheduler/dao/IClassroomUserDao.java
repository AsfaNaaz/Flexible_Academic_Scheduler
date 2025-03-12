package com.scheduler.dao;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.ClassroomUser;



public interface IClassroomUserDao {
	
		   public void save(ClassroomUser classroomUser,String SubjectCode,String studentdept, String studentsection)throws SQLException;
		  public List<ClassroomUser> getAllClassroom() throws SQLException;


}
