package com.scheduler.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	private static final String url = "jdbc:mysql://localhost:3306/flexi_acedmic_schedular";
	private static final String user ="root";
	private static final String password = "root";

	public static  Connection  getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);
	}
	public static void CloseResources(Connection con,Statement stat,ResultSet res)
	{
	
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stat != null) {
			
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
