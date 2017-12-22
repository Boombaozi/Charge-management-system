package my;

import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;

public class info {

    public static String[]  getinfo(HttpServletRequest request, HttpServletResponse response) {

        Connection conn = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;


        String[] arr=new String[31];//用来存储查到的数据  arr[29]用来存 当前年费arr[30]用来存月份


        try {

            conn = DBUtils.getConnection();

            ps=conn.prepareStatement("select  YEAR(current_timestamp) as t1");
            rs=ps.executeQuery();
            while (rs.next()){
                int t1;
                t1= rs.getInt("t1");
                arr[29]=String.valueOf(t1);

            }


            ps=conn.prepareStatement("select  MONTH(current_timestamp) as t2");
            rs=ps.executeQuery();
            while (rs.next()){
                int t2;
                t2= rs.getInt("t2")-1;
                arr[30]=String.valueOf(t2);

            }


            ps = conn.prepareStatement("select count(*) as a from client");
            rs = ps.executeQuery();
            while (rs.next()) {
                arr[0] = rs.getString("a");
            }



            ps= conn.prepareStatement("select sum(enum) as b from einfo where YEAR(data)=? and MONTH(data)=?");
            ps.setString(1,arr[29]);
            ps.setString(2,arr[30]);
            rs=ps.executeQuery();
            while (rs.next()){
                arr[1]=rs.getString("b");
            }







        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            DBUtils.closeAll(rs, ps, conn);
        }

        return arr;

    }


}


