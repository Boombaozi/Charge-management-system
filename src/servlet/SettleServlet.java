package servlet;

import domain.Cr;
import domain.Etype;
import org.apache.commons.beanutils.BeanUtils;
import service.EtypeServiceImpl;
import service.MainImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "SettleServlet")
public class SettleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        request.setCharacterEncoding("UTF-8");


        Cr cr= new Cr();
        try {
            BeanUtils.populate(cr,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        Date d;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       d=cr.getDate();
        simpleDateFormat.format(d);
       cr.setDate(d);

 MainImpl main = new MainImpl();
 main.settle1(cr);

      // response.getWriter().write("what??"+"   序号："+cr.getCno()+"   时间："+cr.getDate()+"   操作员："+"cr.setEno()");

        // response.sendRedirect("/web/etypelist");
        // request.getRequestDispatcher("/web/etypelist").forward(request, response);
        //不写/代表相对路径，相对于本类的路径
      request.getRequestDispatcher("crlist").forward(request, response);






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doPost(request,response);
    }
}
