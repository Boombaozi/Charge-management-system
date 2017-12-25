package webservlet.Cr;

import domain.Cr;
import domain.Etype;
import service.CrServiceImpl;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CrList")
public class CrList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑

        CrServiceImpl crlist= new CrServiceImpl();

        List<Cr> a=crlist.findAllCr1();


        //跳转页面
        if(a!=null){
            request.setAttribute("crlist",a);//把list放入到request对象中
            request.getRequestDispatcher("/cr.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
