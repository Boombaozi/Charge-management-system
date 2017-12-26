package webservlet.Einfo;

import dao.EinfoDaoImpl;
import domain.*;
import service.EinfoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EinfoList")
public class EinfoList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑


        request.setCharacterEncoding("UTF-8");

        EinfoServiceImpl einfoDao = new EinfoServiceImpl();

        List<Einfo> e= einfoDao.findAllEinfo1();



        //跳转页面
        if(e!=null){
            request.setAttribute("einfo",e);//把list放入到request对象中
            request.getRequestDispatcher("/m-einfo.jsp").forward(request, response);
        }else{

            response.getWriter().write("what??");

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
