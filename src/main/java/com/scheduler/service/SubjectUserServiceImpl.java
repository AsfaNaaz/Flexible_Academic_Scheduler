package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.dao.ISubjectUserDao;
import com.scheduler.dao.SubjectUserDaoImpl;
import com.scheduler.model.SubjectUser;

public class SubjectUserServiceImpl implements ISubjectService{
	private static ISubjectService subjectUserService;
	
	private SubjectUserServiceImpl() {
		
	}
	
	public static ISubjectService getSubjectUserService() {
		if(subjectUserService==null)
			subjectUserService=new SubjectUserServiceImpl();
		return subjectUserService;
	}

	@Override
	public void saveUser(SubjectUser subjectUser,String teacherId) throws SQLException {
		ISubjectUserDao subjectUserDao=SubjectUserDaoImpl.getSubjectUserDao();
		subjectUserDao.save(subjectUser,teacherId);
		
		
	}
	
	public List<SubjectUser> getAllSubject() throws SQLException{
		ISubjectUserDao subjectUserDao=SubjectUserDaoImpl.getSubjectUserDao();
		List<SubjectUser> allSubject=subjectUserDao.getAllSubject();
		return allSubject;
	}

}
