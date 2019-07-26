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
			// 接受激活码
			String code = request.getParameter("code");
			// 根据激活码查询用户
			UserService userService = new UserServiceImpl();
			User user = userService.findByCode(code);
			// 判断结果
			if (user != null) {
				// 用户查询到，修改用户状态
				user.setState(0);
				user.setCode(null);
				userService.update(user);
				// 添加信息
				request.setAttribute("msg", "邮箱已经激活，请去登陆！");
			} else {
				// 用户未查询到，
				request.setAttribute("msg", "邮箱激活码有误，请重新激活！");
			}
			// 页面跳转
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
