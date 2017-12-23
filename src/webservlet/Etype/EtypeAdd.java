package webservlet.Etype;

import dao.EtypeDao;
import dao.EtypeDaoImpl;
import domain.Etype;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "etypeadd")
public class EtypeAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑////
        request.setCharacterEncoding("UTF-8");


        Etype etype = new Etype();
        try {
            BeanUtils.populate(etype,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



       EtypeServiceImpl a= new EtypeServiceImpl();
        a.addEtype(etype);

        //response.getWriter().write("what??"+"   序号："+etype.getEtno()+"   名称："+etype.getEtname()+"   价格："+etype.getPrice());

       // response.sendRedirect("/web/etypelist");
       // request.getRequestDispatcher("/web/etypelist").forward(request, response);
        //不写/代表相对路径，相对于本类的路径
        request.getRequestDispatcher("etypelist").forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
