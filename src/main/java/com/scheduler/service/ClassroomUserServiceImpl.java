package com.scheduler.service;

import java.sql.SQLException;
import java.util.List;

import com.scheduler.dao.ClassroomUserDaoImpl;
import com.scheduler.dao.IClassroomUserDao;
import com.scheduler.model.ClassroomUser;

public class ClassroomUserServiceImpl implements IClassroomService{
	
private static IClassroomService classroomUserService;
private ClassroomUserServiceImpl() {
	
}
 public static IClassroomService getClassroomUserService() {
	 if(classroomUserService==null)
		 classroomUserService=new ClassroomUserServiceImpl();
	 return classroomUserService;
 }
 public void saveUser (ClassroomUser classroomUser,String SubjectCode,String studentdept, String studentsection)throws SQLException{
	 IClassroomUserDao classroomUserDao=ClassroomUserDaoImpl.getClassroomUserDao();
	 classroomUserDao.save(classroomUser,SubjectCode, studentdept, studentsection);
 }

public List<ClassroomUser> getAllClassroom() throws SQLException{
	IClassroomUserDao classroomUserDao=ClassroomUserDaoImpl.getClassroomUserDao();
	List<ClassroomUser> allClassroom=classroomUserDao.getAllClassroom();
	return allClassroom;
}

}
