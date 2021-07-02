package com.wukong.servlet.user;

import com.wukong.pojo.User;
import com.wukong.service.user.UserService;
import com.wukong.service.user.UserServiceImpl;
import com.wukong.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login.do")
public class LoginServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("login ============ " );
		//获取用户名和密码
		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");
		//调用service方法，进行用户匹配
		UserService userService = new UserServiceImpl();
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			//放入session
			request.getSession().setAttribute(Constants.USER_SESSION, user);
			//页面跳转（frame.jsp）
			response.sendRedirect(request.getContextPath()+ "/jsp/frame.jsp");
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			String error = "tip:username or password error, 请重试";
			request.setAttribute("errorKey", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}



}
