package com.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.scheduler.factory.DatabaseUtil;
import com.scheduler.model.SubjectUser;
import com.scheduler.model.TeacherUser;

public class SubjectUserDaoImpl implements ISubjectUserDao{
	
	private static final String Subject_User_Query="insert into subject(subjectcode,dept,semester,section,tid)values (?,?,?,?,(select id from teacher where teacherid=? ))";
	private static final String Subject_select_query="select subjectcode,dept,semester,section from subject";
	private static ISubjectUserDao subjectUserDao;
	private SubjectUserDaoImpl() {
		
	}
	
	public static ISubjectUserDao getSubjectUserDao() {
		if(subjectUserDao==null)
		{
			subjectUserDao=new SubjectUserDaoImpl();
		}
		return subjectUserDao;
	}
	

	@Override
	public void save(SubjectUser subjectUser, String teacherId) throws SQLException {
		Connection connection=DatabaseUtil.getConnection();
		PreparedStatement preparedStatement=null;
		if(connection!=null) {
			preparedStatement=connection.prepareStatement(Subject_User_Query);
			if(preparedStatement!=null)
			{
				preparedStatement.setString(1, subjectUser.getScode());
				preparedStatement.setString(2, subjectUser.getSdept());
				preparedStatement.setString(3, subjectUser.getSsem());
				preparedStatement.setString(4, subjectUser.getSsec());
				preparedStatement.setString(5, teacherId);
				
				preparedStatement.executeUpdate();
				
			}
		}
		DatabaseUtil.CloseResources(connection, preparedStatement, null);
		
		
	}
	public List<SubjectUser> getAllSubject() throws SQLException{
		Connection connection=DatabaseUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		List<SubjectUser> res=new ArrayList<>() ;
		if(connection!=null)
		{
			preparedStatement=connection.prepareStatement(Subject_select_query);
			if(preparedStatement!=null)
			{
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					SubjectUser subjectUser=new SubjectUser();
					subjectUser.setScode(resultSet.getString("SubjectCode"));
					subjectUser.setSdept(resultSet.getString("dept"));
					subjectUser.setSsec(resultSet.getString("section"));
					subjectUser.setSsem(resultSet.getString("semester"));
					res.add(subjectUser);
					
					
				}
			}
		}
		DatabaseUtil.CloseResources(connection, preparedStatement, resultSet);
		return res;
		
	}

}
