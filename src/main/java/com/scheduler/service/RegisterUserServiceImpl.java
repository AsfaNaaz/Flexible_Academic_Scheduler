
package com.scheduler.service;

import java.sql.SQLException;

import org.apache.coyote.RequestGroupInfo;

import com.scheduler.dao.IRegisterUserDao;
import com.scheduler.dao.RegisterUserDaoImpl;
import com.scheduler.model.RegisterUser;

public class RegisterUserServiceImpl  implements IRegisterService{
	
   private static  IRegisterService registerUserService; 
   
	private RegisterUserServiceImpl() {//singleton  
		
		
	}
	
	public static  IRegisterService getRegisterUserService() {
		if(registerUserService==null)
			registerUserService=new RegisterUserServiceImpl();
		return registerUserService;
	}

	

	@Override
	public void saveUser(RegisterUser registerUser) throws SQLException {
		IRegisterUserDao registerUserDao = RegisterUserDaoImpl.getRegisterUserDao();
		registerUserDao.save(registerUser);
		
	}

	
	
}
