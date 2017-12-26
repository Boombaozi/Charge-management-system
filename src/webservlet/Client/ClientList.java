package webservlet.Client;

import domain.*;
import service.ClientServiceImpl;
import service.EinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientList")
public class ClientList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑


        request.setCharacterEncoding("UTF-8");

        ClientServiceImpl clientService = new ClientServiceImpl();

        List<client> c= clientService.findAllClient1();





        //跳转页面
        if(c!=null){
            request.setAttribute("client",c);//把list放入到request对象中
            request.getRequestDispatcher("/m-client.jsp").forward(request, response);
        }else{

            response.getWriter().write("what??出错了");

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
