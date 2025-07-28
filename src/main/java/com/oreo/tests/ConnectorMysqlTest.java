package com.oreo.tests;

import com.oreo.dao.ConnectorMysql;

public class ConnectorMysqlTest{
	
	public static void main(String[] args) {
		ConnectorMysql con = new ConnectorMysql();
		System.out.println(con.getCon());
	}
	
}