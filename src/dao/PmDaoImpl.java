package dao;

import domain.Pm;
import domain.client;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class PmDaoImpl implements PmDao {
    @Override
    public List<Pm> findAllPm() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.pm", new BeanListHandler<Pm>(Pm.class));


    }

    @Override
    public void addPm(Pm p) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.pm VALUES(?,?,?,?,current_timestamp)",
                p.getCno(),p.getDate(),p.getCharge(),p.getSign());

    }

    @Override
    public void deletePm(Pm p) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.pm where cno=? and date=?",p.getCno(),p.getDate());
    }

    @Override
    public void updatePmsign(Pm p) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update pm set sign=? where cno=? and date=?",
                p.getSign(),p.getCno(),p.getDate());

    }

    @Override
    public Pm findPmById(Pm p) throws SQLException {
    QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
    return qr.query("select * from pm where cno=? and date=?",new BeanHandler<Pm>(Pm.class),
            p.getCno(),p.getDate());


    }
}
