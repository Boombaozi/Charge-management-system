package test;

import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "inserttest",urlPatterns="/servlet/itest")
public class inserttest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Connection conn=null;
        PreparedStatement ps =null;

        try {
            conn= DBUtils.getConnection();
            ps = conn.prepareStatement("insert into users(id,password,Email,Eno,create_at) values(555,5555,55,2,current_timestamp)");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  doPost(request,response);
    }
}
