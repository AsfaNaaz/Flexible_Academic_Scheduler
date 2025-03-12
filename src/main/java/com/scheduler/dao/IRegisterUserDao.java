
package com.scheduler.dao;

import java.sql.SQLException;

import com.scheduler.model.RegisterUser;

public interface IRegisterUserDao {
	public void save(RegisterUser registerUser) throws SQLException;

}
