package com.test.mail.service.impl;

import com.test.mail.dao.UserDao;
import com.test.mail.dao.impl.UserDaoImpl;
import com.test.mail.domain.User;
import com.test.mail.service.UserService;
import com.test.mail.utils.EmailUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	public void insertUser(User user) throws Exception {
		// �û�����
		userDao.insertUser(user);
		// ���ͼ����ʼ�
		EmailUtils.sendEmail(user.getEmil(), user.getCode());

	}

	public User findByCode(String code) throws Exception {
		// ��ѯ�û�
		return userDao.findByCode(code);
	}

	public void update(User user) throws Exception {
		userDao.update(user);
	}

}
