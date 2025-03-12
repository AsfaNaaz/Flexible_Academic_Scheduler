package com.scheduler.dao;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.SubjectUser;

public interface ISubjectUserDao {
   public void save(SubjectUser subjectUser,String teacherId)throws SQLException;
   public List<SubjectUser> getAllSubject() throws SQLException;
}
