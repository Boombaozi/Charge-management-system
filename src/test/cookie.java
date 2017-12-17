package test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class cookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取客户端保存的最后访问时间
        Cookie[] cookies = request.getCookies();//获取客户端的所有Cookie对象
        for (int i = 0;cookies!=null && i < cookies.length; i++) {
            if("lastAccessTime".equals(cookies[i].getName())){//判断当前Cookie中的name是否是想要的cookie
                long l = Long.parseLong(cookies[i].getValue());//如果是想要的Cookie，则把Cookie中的value取出
                out.write("你的最后访问时间为："+new Date(l).toLocaleString());//yyyy-MM-dd
            }
        }

        out.print("<a href='"+request.getContextPath()+"/servlet/clear'>clear</a>");
        //创建cookie，
        Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //设置cookie的有效时间,单位是秒
        ck.setMaxAge(60*5);//保存时间为5分钟
        //设置cookie的path
        //ck.setPath("/day10_00_cookie");
        //ck.setPath(request.getContextPath());//  /day10_00_cookie
        ck.setPath("/");//  /day10_00_cookie
        //把cookie信息写回到客户端
        response.addCookie(ck);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
