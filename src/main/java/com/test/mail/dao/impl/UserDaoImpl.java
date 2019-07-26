package com.test.mail.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.test.mail.dao.UserDao;
import com.test.mail.domain.User;
import com.test.mail.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	public void insertUser(User user) throws Exception {
		// 获取sql执行器
		QueryRunner runner = new QueryRunner(JDBCUtils.getResource());
		// sql
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		// param
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getNickname(), user.getEmil(),
				user.getState(), user.getCode() };
		// 执行sql
		runner.update(sql, params);
	}

	/**
	 * 根据激活码查询用户
	 * 
	 * @throws SQLException
	 */
	public User findByCode(String code) throws Exception {
		// 获取sql执行器
		QueryRunner runner = new QueryRunner(JDBCUtils.getResource());
		// sql
		String sql = "select *from user where code=?";
		// 进行查询
		User query = runner.query(sql, new BeanHandler<User>(User.class), code);
		return query;
	}

	public void update(User user) throws Exception {
		// 获取sql执行器
		QueryRunner runner = new QueryRunner(JDBCUtils.getResource());

		// sql
		String sql = "update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getNickname(), user.getEmil(), user.getState(),
				user.getCode(), user.getUid() };
		runner.update(sql, params);
	}

}
