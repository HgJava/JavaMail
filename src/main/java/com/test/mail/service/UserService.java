package com.test.mail.service;

import com.test.mail.domain.User;

public interface UserService {

	void insertUser(User user) throws Exception;

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;

}
