package com.test.mail.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mail.domain.User;
import com.test.mail.service.UserService;
import com.test.mail.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActiveServlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// ���ܼ�����
			String code = request.getParameter("code");
			// ���ݼ������ѯ�û�
			UserService userService = new UserServiceImpl();
			User user = userService.findByCode(code);
			// �жϽ��
			if (user != null) {
				// �û���ѯ�����޸��û�״̬
				user.setState(0);
				user.setCode(null);
				userService.update(user);
				// �����Ϣ
				request.setAttribute("msg", "�����Ѿ������ȥ��½��");
			} else {
				// �û�δ��ѯ����
				request.setAttribute("msg", "���伤�������������¼��");
			}
			// ҳ����ת
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
