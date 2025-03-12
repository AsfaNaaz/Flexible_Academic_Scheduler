package com.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scheduler.factory.DatabaseUtil;
import com.scheduler.model.ClassroomUser;

public class ClassroomUserDaoImpl implements IClassroomUserDao {

	private static final String Classroom_user_Query = "insert into classroom(classroomno,classroomblock,sid)values(?,?,(select id from subject where SubjectCode=? and dept=? and  section=?))";
	private static final String Classroom_select_query="select classroomno,classroomblock from classroom"; 

	private static IClassroomUserDao classroomUserDao;

	private ClassroomUserDaoImpl() {

	}

	public static IClassroomUserDao getClassroomUserDao() {
		if (classroomUserDao == null) {
			classroomUserDao = new ClassroomUserDaoImpl();

		}
		return classroomUserDao;
	}

	@Override
	public void save(ClassroomUser classroomUser, String SubjectCode,String studentdept, String studentsection) throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		PreparedStatement preparedStatement = null;
		if (connection != null) {
			preparedStatement = connection.prepareStatement(Classroom_user_Query);
			if (preparedStatement != null) {
				preparedStatement.setString(1, classroomUser.getCno());
				preparedStatement.setString(2, classroomUser.getCblock());
				preparedStatement.setString(3, SubjectCode);
				preparedStatement.setString(4, studentdept);
				preparedStatement.setString(5, studentsection);
				preparedStatement.executeUpdate();

			}

		}
		DatabaseUtil.CloseResources(connection, preparedStatement, null);
		
	}
	public List<ClassroomUser> getAllClassroom() throws SQLException {
		Connection connection=DatabaseUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<ClassroomUser> res= new ArrayList<>();
		if(connection!=null) {
			preparedStatement=connection.prepareStatement(Classroom_select_query);
			if(preparedStatement!=null)
			{
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					ClassroomUser classroomUser=new ClassroomUser();
					classroomUser.setCno(resultSet.getString("classroomno"));
					classroomUser.setCblock(resultSet.getString("classroomblock"));
					res.add(classroomUser);
				}
			}
			
		}
		DatabaseUtil.CloseResources(connection, preparedStatement, resultSet);
		return res;
	}
	

}
