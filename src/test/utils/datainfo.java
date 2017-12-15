package test.utils;

import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

public class datainfo {
	
		
    public static void getdatainfo2(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
			{
				
	Connection conn = null;
	java.sql.PreparedStatement ps = null;
	ResultSet rs = null;
				response.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'><br/>");
				response.getWriter().write("aaaaaa");
	try {
		conn = DBUtils.getConnection();
		ps = conn.prepareStatement("select * from etype");
		response.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'><br/>");
		
		rs = ps.executeQuery();
		if (rs.next())
		{
			response.getWriter().write("数据不为空");
		}
		else
		{

			response.getWriter().write("数据为空");
		}
		while(rs.next()){
			response.getWriter().write("<br/>");
			response.getWriter().write(rs.getString(1)+" ");
			response.getWriter().write(rs.getString(2)+" ");
			response.getWriter().write(rs.getString(3)+" ");
			response.getWriter().write("<br/>--------------------<br/>");
		}
					
		
		
	} catch (Exception e) {
		e.printStackTrace();
		response.getWriter().write("cuowu!!!!!!");
	}finally{
		DBUtils.closeAll(rs, ps, conn);
	}
	     	
		}
	    	
  
	
    
    
	
	
	
}
