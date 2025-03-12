package com.scheduler.dao;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.TeacherUser;

public interface ITeacherUserDao {
     public void save(TeacherUser teacherUser) throws SQLException;
     public List<TeacherUser> getAllTeacher() throws SQLException;
}
