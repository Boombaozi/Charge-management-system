package servlet;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import domain.User;
import service.UserService;
import service.UserServiceImpl;

@WebServlet(name = "RegServlet",urlPatterns="/servlet/regServlet")
public class RegServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		response.setContentType("text/html;charset=UTF-8");



            User user = new User();
            try {
				BeanUtils.populate(user,request.getParameterMap());
			} catch (Exception e) {

				response.getWriter().write("获取表单失败");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



			UserService us = new UserServiceImpl();
			try {
				us.register(user);
			} catch (Exception e) {

				response.getWriter().write("注册失败");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			response.getWriter().write("注册成功");
			
			
			response.setHeader("refresh", "1;url=" + request.getContextPath()
					+ "/login.jsp");
			
			
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  doGet(request, response);
		
	}

}
