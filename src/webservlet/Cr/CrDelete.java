package webservlet.Cr;

import domain.Cr;
import org.apache.commons.beanutils.BeanUtils;
import service.CrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CrDelete")
public class CrDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        request.setCharacterEncoding("UTF-8");

        Cr cr =new Cr();

        try {
            BeanUtils.populate(cr,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        CrServiceImpl crService = new CrServiceImpl();



        crService.deleteCr1(cr);


        //不写/代表相对路径，相对于本类的路径
        request.getRequestDispatcher("crlist").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
