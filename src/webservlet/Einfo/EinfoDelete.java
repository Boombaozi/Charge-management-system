package webservlet.Einfo;

import domain.Einfo;
import domain.Etype;
import org.apache.commons.beanutils.BeanUtils;
import service.EinfoServiceImpl;
import service.EtypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EinfoDelete")
public class EinfoDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");

        Einfo einfo=new Einfo();
        try {
            BeanUtils.populate(einfo,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        EinfoServiceImpl a= new EinfoServiceImpl();

        a.deleteEinfo1(einfo);
        //response.getWriter().write("what??"+"   序号："+etype.getEtno()+"   名称："+etype.getEtname()+"   价格："+etype.getPrice());

        request.getRequestDispatcher("einfolist").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
