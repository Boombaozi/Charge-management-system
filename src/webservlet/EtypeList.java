package webservlet;

import dao.EtypeDaoImpl;
import domain.Etype;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "etypelist")
public class EtypeList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        EtypeServiceImpl etlist= new EtypeServiceImpl();

        List<Etype> a = etlist.findAllEtype();



        //跳转页面
        if(a!=null){
            request.setAttribute("etypelist",a);//把list放入到request对象中
            request.getRequestDispatcher("/m-etype.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
