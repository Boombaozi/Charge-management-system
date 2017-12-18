package dao;


import domain.User;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao {

    public void addUser(User user) throws Exception {
        // TODO Auto-generated method stub

        Connection conn=null;
        PreparedStatement ps =null;


        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into users(id,password,email,eno,create_at) values(?,?,?,?,current_timestamp)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getEno());


            int i = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("");
        }finally{
            DBUtils.closeAll(null,ps, conn);


        }
    }


    public User findUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where id=? and password=?");
            ps.setString(1, user.getId());
            ps.setString(2, user.getPassword());



            rs = ps.executeQuery();
            if(rs.next()){
                u = new User();
                u.setId(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setEno(rs.getString(4));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeAll(rs, ps, conn);
        }
        return u;
    }


    public boolean findUserByName(String id) {
        // TODO Auto-generated method stub
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where id=?");
            ps.setString(1,id);
            boolean aa;
            rs = ps.executeQuery();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            if(rs.next()){
                DBUtils.closeAll(null,ps, conn);
                return true;

            }
            else
            {

                DBUtils.closeAll(null,ps, conn);
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
