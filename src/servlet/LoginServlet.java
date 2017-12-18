package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import domain.User;
import service.UserService;

import service.UserServiceImpl;

@WebServlet(name = "LoginServlet",urlPatterns="/servlet/loginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");

        
        User user = new User();
        try {
			BeanUtils.populate(user,request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserService us = new UserServiceImpl();
		
		User u=null;
		try {
			u = us.login(user);
		

			if(u!=null){
				response.setHeader("refresh", "0;url=" + request.getContextPath()
						+ "/index.jsp");
			}

			else {
				if(us.finduserbyname(user.getId())==false )
				{

					response.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
					response.getWriter().write("用户不存在");
					response.setHeader("refresh", "2;url=" + request.getContextPath()
							+ "/login.jsp");

				}
		         else
				{
		         response.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
				response.getWriter().write("密码错误");
				response.setHeader("refresh", "2;url=" + request.getContextPath()
						+ "/login.jsp");
				}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
