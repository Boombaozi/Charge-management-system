package webservlet.Einfo;

import domain.Einfo;
import domain.Etype;
import domain.Pm;
import org.apache.commons.beanutils.BeanUtils;
import service.EinfoServiceImpl;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EinfoAdd")
public class EinfoAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        request.setCharacterEncoding("UTF-8");


        Einfo einfo = new Einfo();
        try {
            BeanUtils.populate(einfo,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        EinfoServiceImpl einfoService = new EinfoServiceImpl();


        einfoService.addEinfo1(einfo);

       // response.getWriter().write("what??"+
           //     "   序号："+einfo.getCno()+"   名称："+einfo.getDate()+"   价格："+einfo.getEtno()+einfo.getEenum());

        // response.sendRedirect("/web/etypelist");
        // request.getRequestDispatcher("/web/etypelist").forward(request, response);
        //不写/代表相对路径，相对于本类的路径
        request.getRequestDispatcher("einfolist").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
