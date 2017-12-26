package webservlet.E;

import domain.*;
import org.apache.commons.beanutils.BeanUtils;
import service.EServiceImpl;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EAdd")
public class EAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        request.setCharacterEncoding("UTF-8");


        Employees em = new Employees();
        try {
            BeanUtils.populate(em,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        EServiceImpl eService = new EServiceImpl();

        eService.addE1(em);

       // response.getWriter().write("what??"+"   序号："
         //       +em.getEno()+"   名称："+em.getName()+"   价格："+em.getSex()+em.getEtel() );


        //不写/代表相对路径，相对于本类的路径
        request.getRequestDispatcher("elist").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
