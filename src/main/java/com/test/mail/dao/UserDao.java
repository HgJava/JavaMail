package com.test.mail.dao;

import java.sql.SQLException;

import com.test.mail.domain.User;

public interface UserDao {

	void insertUser(User user) throws Exception;

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;

}
