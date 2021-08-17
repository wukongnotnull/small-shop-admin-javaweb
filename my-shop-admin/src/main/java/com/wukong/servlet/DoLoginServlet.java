package com.wukong.servlet;/*
author: ??????B?/??/???? 
*/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DoLoginServlet", value = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        if(user.equals("admin") && password.equals("admin")){
            System.out.println("登录成功");
        }else {
            request.setAttribute("loginFail","登录失败啊");
            request.getRequestDispatcher("/denglu.jsp").forward(request,response);
        }
    }
}
