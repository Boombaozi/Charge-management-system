package my;

import utils.DBUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;

public class nowtime {

    public static String[]  getinfo() {

        Connection conn = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;


        String[] arr=new String[3];//用来存储查到的数据  arr[0]用来存 当前年费arr[1]用来存月份


        try {

            conn = DBUtils.getConnection();

            ps=conn.prepareStatement("select  YEAR(current_timestamp) as t1");
            rs=ps.executeQuery();
            while (rs.next()){
                int t1;
                t1= rs.getInt("t1");
                arr[0]=String.valueOf(t1);

            }


            ps=conn.prepareStatement("select  MONTH(current_timestamp) as t2");
            rs=ps.executeQuery();
            while (rs.next()){
                int t2;
                t2= rs.getInt("t2");
                arr[1]=String.valueOf(t2);

            }
            ps=conn.prepareStatement("select  DAY(current_timestamp) as t3");
            rs=ps.executeQuery();
            while (rs.next()){
                int t3;
                t3= rs.getInt("t3");
                arr[2]=String.valueOf(t3);

            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            DBUtils.closeAll(rs, ps, conn);
        }

        return arr;

    }


}
