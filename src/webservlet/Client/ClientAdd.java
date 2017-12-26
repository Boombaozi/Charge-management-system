package webservlet.Client;

import domain.Pm;
import domain.client;
import org.apache.commons.beanutils.BeanUtils;
import service.ClientServiceImpl;
import service.PmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientAdd")
public class ClientAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用 业务逻辑
        request.setCharacterEncoding("UTF-8");

        client client = new client();
        try {
            BeanUtils.populate(client,request.getParameterMap());
        } catch (Exception e) {

            response.getWriter().write("获取表单失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.addClient1(client);
       //  response.getWriter().write("what??"+"   序号：" +
       //         ""+client.getCno()+"   名称："+client.getCname()+"   价格："+client.getAddr()
       //  +client.getCtel()+client.getMoney());


        request.getRequestDispatcher("clientlist").forward(request, response);






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
