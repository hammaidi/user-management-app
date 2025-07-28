package com.oreo.tests;

import com.oreo.dao.UserDaoMysqlmp;
import com.oreo.entity.User;

public class UserDaolmplTest{
	
	
	public static void main(String[] args) {
	//	ConnectorMysqlTest
		
//		UserDaoImpl Test = new UserDaoImpl();
//		
//		Test.displayUsers();
//		
//		
		//----
		UserDaoMysqlmp agentMysqlDao = new UserDaoMysqlmp();
		
		agentMysqlDao.displayUsers();
		
		
		agentMysqlDao.addUser(new User("toto","tito"));
		
		agentMysqlDao.displayUsers();
	}
		
}



