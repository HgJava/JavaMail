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
	 * �����ӳ��л�ȡ����
	 * @return
	 * @throws Exception
	 */
	public static ComboPooledDataSource getResource() throws Exception {
		//����һ�����ӳض���
		ComboPooledDataSource pool=new ComboPooledDataSource();
		//�������������
		pool.setDriverClass(driver);
		//����Ҫ��ȡ���Ӷ���
		//�������ӳ��������ֵ������
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
