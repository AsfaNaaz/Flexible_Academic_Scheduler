package com.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.scheduler.factory.DatabaseUtil;
import com.scheduler.model.RegisterUser;

public class RegisterUserDaoImpl implements IRegisterUserDao {

	private static final String Register_User_Query = "insert into admin(user_id,password)values (?,?)";

	private static IRegisterUserDao registerUserDao;

	private RegisterUserDaoImpl() {

	}

	public static IRegisterUserDao getRegisterUserDao() {
		if (registerUserDao == null) {
			registerUserDao = new RegisterUserDaoImpl();
		}
		return registerUserDao;
	}

	@Override
	public void save(RegisterUser registerUser) throws SQLException {

		Connection connection = DatabaseUtil.getConnection();
		PreparedStatement prepareStatement = null;
		if (connection != null) {
			prepareStatement = connection.prepareStatement(Register_User_Query);

			if (prepareStatement != null) {
				prepareStatement.setString(1, registerUser.getUsername());
				prepareStatement.setString(2, registerUser.getPassword());

				prepareStatement.executeUpdate();
			}

		}
		DatabaseUtil.CloseResources(connection, prepareStatement, null);

	}

}
