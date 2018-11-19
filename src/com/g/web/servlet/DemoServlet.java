package com.g.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        // 设置刷新自动加载时间为 5 秒
        resp.setIntHeader("Refresh", 5);
        //使用默认时区和语言环境获得一个日历
        Calendar cale = Calendar.getInstance();
        //将Calendar类型转换成Date类型
        Date tasktime=cale.getTime();
        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化输出
        String nowTime = df.format(tasktime);

        // 实际的逻辑是在这里
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "别说话我就是要中分" + "</h1>");

        out.println();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);

    }
}
