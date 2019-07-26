package com.test.mail.service.impl;

import com.test.mail.dao.UserDao;
import com.test.mail.dao.impl.UserDaoImpl;
import com.test.mail.domain.User;
import com.test.mail.service.UserService;
import com.test.mail.utils.EmailUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	public void insertUser(User user) throws Exception {
		// 用户插入
		userDao.insertUser(user);
		// 发送激活邮件
		EmailUtils.sendEmail(user.getEmil(), user.getCode());

	}

	public User findByCode(String code) throws Exception {
		// 查询用户
		return userDao.findByCode(code);
	}

	public void update(User user) throws Exception {
		userDao.update(user);
	}

}
