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



            ps= conn.prepareStatement("select sum(enum) as b from einfo where YEAR(date)=? and MONTH(date)=?");
            ps.setString(1,arr[29]);
            ps.setString(2,arr[30]);
            rs=ps.executeQuery();
            while (rs.next()){
                arr[1]=rs.getString("b");
            }

            ps= conn.prepareStatement("SELECT count(*) as c from pm where sign=? and  year(date)=? and month(date)-1=?");
            ps.setString(1,"已收");
            ps.setString(2,arr[29]);
            ps.setString(3,arr[30]);
            rs=ps.executeQuery();
            while (rs.next()){
                arr[2]=rs.getString("c");
            }

            ps= conn.prepareStatement("SELECT count(*) as d from pm where sign=? and  year(date)=? and month(date)-1=? ");
            ps.setString(1,"未收");
            ps.setString(2,arr[29]);
            ps.setString(3,arr[30]);
            rs=ps.executeQuery();
            while (rs.next()){
                arr[3]=rs.getString("d");
            }

            ps= conn.prepareStatement("select sum(enum) as e from einfo  where etno=1;");

            rs=ps.executeQuery();
            while (rs.next()){
                arr[4]=rs.getString("e");
            }

            ps= conn.prepareStatement("select sum(enum) as f from einfo  where etno=2;");

            rs=ps.executeQuery();
            while (rs.next()){
                arr[5]=rs.getString("f");
            }

            ps= conn.prepareStatement("select sum(enum) as g from einfo  where etno=3;");

            rs=ps.executeQuery();
            while (rs.next()){
                arr[6]=rs.getString("g");
            }

            ps= conn.prepareStatement("select sum(enum) as h from einfo  where etno=4;");

            rs=ps.executeQuery();
            while (rs.next()){
                arr[6]=rs.getString("h");
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            DBUtils.closeAll(rs, ps, conn);
        }

        return arr;

    }

    public static int[]  getinfo1(HttpServletRequest request, HttpServletResponse response) {

        Connection conn = null;
        java.sql.PreparedStatement ps = null;
        ResultSet rs = null;


        int[] a=new int[31];//用来存储查到的数据  arr[29]用来存 当前年费arr[30]用来存月份


        try {

            conn = DBUtils.getConnection();

            ps=conn.prepareStatement("select  YEAR(current_timestamp) as t1");
            rs=ps.executeQuery();
            while (rs.next()){

                a[29]= rs.getInt("t1");


            }


            ps=conn.prepareStatement("select  MONTH(current_timestamp) as t2");
            rs=ps.executeQuery();
            while (rs.next()){

                a[30]= rs.getInt("t2")-1;


            }


            ps= conn.prepareStatement("select sum(enum) as e from einfo  where etno=1;");

            rs=ps.executeQuery();
            while (rs.next()){
                a[4]=rs.getInt("e");
            }

            ps= conn.prepareStatement("select sum(enum) as f from einfo  where etno=2;");

            rs=ps.executeQuery();
            while (rs.next()){
                a[5]=rs.getInt("f");
            }

            ps= conn.prepareStatement("select sum(enum) as g from einfo  where etno=3;");

            rs=ps.executeQuery();
            while (rs.next()){
                a[6]=rs.getInt("g");
            }

            ps= conn.prepareStatement("select sum(enum) as h from einfo  where etno=4;");

            rs=ps.executeQuery();
            while (rs.next()){
                a[7]=rs.getInt("h");
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            DBUtils.closeAll(rs, ps, conn);
        }

        return a;

    }
}


