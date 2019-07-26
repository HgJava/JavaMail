package com.test.mail.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mail.domain.User;
import com.test.mail.service.UserService;
import com.test.mail.service.impl.UserServiceImpl;
import com.test.mail.utils.UUIDUtils;

/**
 * Servlet implementation class regist
 */
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 获取用户信息进行储存
			// 首先进行乱码处理
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String code = UUIDUtils.getCode();
			Integer state = 0;
			User user = new User(null, username, password, nickname, email, state, code);
			UserService userService = new UserServiceImpl();
			userService.insertUser(user);
			//用户进行跳转
			request.setAttribute("msg", "请您去邮箱进行激活操作！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
