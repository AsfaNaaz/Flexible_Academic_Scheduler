package com.scheduler.service;

import java.sql.SQLException;

import com.scheduler.model.RegisterUser;

public interface IRegisterService {
    public void saveUser(RegisterUser registerUser) throws SQLException;
    	
    
}
