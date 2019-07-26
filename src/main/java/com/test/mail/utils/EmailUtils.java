package com.test.mail.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * 
 * @author 劳资独宠一方
 *
 */
public class EmailUtils {
	// 给谁发送邮件，发送什么(激活码)
	public static void sendEmail(String to, String code) throws Exception {
		// 1.创建连接对象
		Session session = Session.getDefaultInstance(new Properties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com", "123");
			}
		});
		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@store.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 主题
		message.setSubject("来自store的激活邮件");
		// 正文
		message.setContent(
				"<h1>来自dt的激活邮件，点击链接激活账号：</h1><h3><a href='http://localhost:8080/JavaMailTest/ActiveServlet?code=" + code
						+ "'>http://localhost:8080/JavaMailTest/ActiveServlet?code=" + code + "</a></h3>",
				"text/html;charset=utf-8");
		// 3.发送激活邮件
		Transport.send(message);
	}
}
