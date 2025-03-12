package com.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scheduler.factory.DatabaseUtil;
import com.scheduler.model.TeacherUser;

public class TeacherUserDaoImpl implements ITeacherUserDao {

	private static final String Teacher_User_Query = "insert into teacher(teachername,teacherid,teacherdept)values (?,?,?)";
	private static final String Teacher_select_query ="select teachername,teacherid,teacherdept from teacher";
	private static ITeacherUserDao teacherUserDao;

	private TeacherUserDaoImpl() {

	}
	public static ITeacherUserDao getTeacherUserDao()
	{
		if(teacherUserDao==null)
		{
			teacherUserDao=new TeacherUserDaoImpl();
		}
		return teacherUserDao;
	}
	@Override
	public void save(TeacherUser teacherUser) throws SQLException {
		Connection connection=DatabaseUtil.getConnection();
		PreparedStatement prepareStatement=null;
		if(connection !=null) {
			prepareStatement = connection.prepareStatement(Teacher_User_Query);
			if(prepareStatement!=null)
			{
				prepareStatement.setString(1,teacherUser.getTname());
				prepareStatement.setString(2,teacherUser.getTid());
				prepareStatement.setString(3,teacherUser.getTdept());
				
				prepareStatement.executeUpdate();
			}
			
		}
		DatabaseUtil.CloseResources(connection, prepareStatement, null);
		
		
	}
	@Override
	public List<TeacherUser> getAllTeacher() throws SQLException {
		Connection connection=DatabaseUtil.getConnection();
		PreparedStatement prepareStatement=null;
		ResultSet resultSet = null;
		List<TeacherUser> res=new ArrayList<>() ;//pjo type list 
		if(connection !=null) {
			prepareStatement = connection.prepareStatement(Teacher_select_query);
			if(prepareStatement!=null)
			{
				//resultset taking  value and giving to list type pojo and return it 
			    resultSet= prepareStatement.executeQuery();
			    while(resultSet.next())
			    {
			    	TeacherUser teacherUser = new TeacherUser();
			    	teacherUser.setTname(resultSet.getString("teachername"));
			    	teacherUser.setTid(resultSet.getString("teacherid"));
			    	teacherUser.setTdept(resultSet.getString("teacherdept"));
			    	res.add(teacherUser);
			    	
			    }
				
			}
			
		}
		DatabaseUtil.CloseResources(connection, prepareStatement,resultSet);
		return res;
	}
}
