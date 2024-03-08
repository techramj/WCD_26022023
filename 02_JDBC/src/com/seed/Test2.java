package com.seed;

import java.sql.Connection;

public class Test2 {
	
	public static void main(String[] args) {
		Connection con1 = ConnectionUtil.getConnection();
		Connection con2 = ConnectionUtil.getConnection();
		System.out.println(con1 == con2);
		
		
	}

}
