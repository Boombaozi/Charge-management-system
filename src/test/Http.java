package test;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Http {

    public static void gethttprequest(HttpServletRequest request,HttpServletResponse response) throws IOException
    {

		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.getWriter().write(request.getServerName());
		response.getWriter().write("中文测试");
	}


}
    
    
    
  
    