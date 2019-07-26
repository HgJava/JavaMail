package com.test.mail.utils;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// url
	private static String url = "jdbc:mysql://localhost:3306/regist_web";
	// driver
	private static String driver = "com.mysql.jdbc.Driver";
	// username
	private static String username = "root";
	// password
	private static String password = "123456";
	
	
	/**
	 * 在连接池中获取连接
	 * @return
	 * @throws Exception
	 */
	public static ComboPooledDataSource getResource() throws Exception {
		//创建一个链接池对象
		ComboPooledDataSource pool=new ComboPooledDataSource();
		//进行驱动的添加
		pool.setDriverClass(driver);
		//不需要获取连接对象
		//进行连接池相关属性值的设置
		pool.setJdbcUrl(url);
		pool.setUser(username);
		pool.setPassword(password);
		pool.setMaxPoolSize(30);
		pool.setMinPoolSize(5);
		pool.setMaxIdleTime(60);
		pool.setAcquireIncrement(5);
		return pool;
	}
}
