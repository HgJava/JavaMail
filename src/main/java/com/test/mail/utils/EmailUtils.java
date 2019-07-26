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
 * �ʼ����͹�����
 * 
 * @author ���ʶ���һ��
 *
 */
public class EmailUtils {
	// ��˭�����ʼ�������ʲô(������)
	public static void sendEmail(String to, String code) throws Exception {
		// 1.�������Ӷ���
		Session session = Session.getDefaultInstance(new Properties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com", "123");
			}
		});
		// 2.�����ʼ�����
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@store.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// ����
		message.setSubject("����store�ļ����ʼ�");
		// ����
		message.setContent(
				"<h1>����dt�ļ����ʼ���������Ӽ����˺ţ�</h1><h3><a href='http://localhost:8080/JavaMailTest/ActiveServlet?code=" + code
						+ "'>http://localhost:8080/JavaMailTest/ActiveServlet?code=" + code + "</a></h3>",
				"text/html;charset=utf-8");
		// 3.���ͼ����ʼ�
		Transport.send(message);
	}
}
