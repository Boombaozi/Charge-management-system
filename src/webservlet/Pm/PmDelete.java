package webservlet.Pm;

import domain.Pm;
import org.apache.commons.beanutils.BeanUtils;
import service.PmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PmDelete")
public class PmDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");

        Pm pm  =new Pm();
        try {
            BeanUtils.populate(pm,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PmServiceImpl pmService = new PmServiceImpl();
        pmService.deletePm1(pm);
        //response.getWriter().write("what??"+"   序号：" +
                //""+pm.getCno()+"   名称："+pm.getDate()+"   价格："+pm.getCharge());


        request.getRequestDispatcher("pmlist").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
