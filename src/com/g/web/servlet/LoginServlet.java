package com.g.web.servlet;

import com.g.beans.User;
import com.g.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
          System.out.print("========="+req.getParameter("username") + "=============" +req.getParameter("password") + "---" + user);
        UserService userService = new UserService();
        try {
            User existUser = userService.login(user);
            if (existUser == null){
                req.setAttribute("msg","账户名或密码有误1！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }else{
                req.getSession().setAttribute("user",existUser);
                resp.sendRedirect("/index.jsp");
            }
        }catch (RuntimeException e){
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
