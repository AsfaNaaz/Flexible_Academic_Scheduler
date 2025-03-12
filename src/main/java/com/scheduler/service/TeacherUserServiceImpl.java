package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.dao.ITeacherUserDao;
import com.scheduler.dao.TeacherUserDaoImpl;
import com.scheduler.model.TeacherUser;

public class TeacherUserServiceImpl implements ITeacherService {

	private static ITeacherService teacherUserService;

	private TeacherUserServiceImpl() {

	}

	public static ITeacherService getTeacherUserService() {
		if (teacherUserService == null)

			teacherUserService = new TeacherUserServiceImpl();
		return teacherUserService;
	}

	@Override
	public void saveUser(TeacherUser teacherUser) throws SQLException {
        ITeacherUserDao teacherUserDao=TeacherUserDaoImpl.getTeacherUserDao();
        teacherUserDao.save(teacherUser);
	}

	@Override
	public List<TeacherUser> getAllTeacher() throws SQLException {
        ITeacherUserDao teacherUserDao=TeacherUserDaoImpl.getTeacherUserDao();
        List<TeacherUser> allTeacher = teacherUserDao.getAllTeacher();

		return allTeacher;
	}

}
