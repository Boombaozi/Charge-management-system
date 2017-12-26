package webservlet.Pm;

import domain.Pm;

import service.PmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PmList")
public class PmList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑


        PmServiceImpl pmService =new PmServiceImpl();


        List<Pm> a =pmService.findAllPm1();



        //跳转页面
        if(a!=null){
            request.setAttribute("pmlist",a);//把list放入到request对象中
            request.getRequestDispatcher("/m-pm.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
