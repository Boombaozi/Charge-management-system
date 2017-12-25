package dao;

import domain.Cr;
import domain.Etype;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class CrDaoImpl implements CrDao {
    @Override
    public List<Cr> findAllCr() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.cr", new BeanListHandler<Cr>(Cr.class));


    }

    @Override
    public void addCr(Cr cr) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.cr VALUES(?,?,?,?,?,current_timestamp)",
                cr.getCno(),cr.getDate(),cr.getSc(),cr.getAc(),cr.getEno());

    }

    @Override
    public void deleteCr(Cr cr) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.cr where cno=? and date=?",
                cr.getCno(),cr.getDate());
    }

    @Override
    public void updateCr(Cr cr) throws SQLException {

    }

    @Override
    public Cr findCrById(Cr cr) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.cr where cno=? and data=?",
                new BeanHandler<Cr>(Cr.class), cr.getCno(), cr.getDate());


    }

    @Override
    public void addCr2(Cr cr) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.cr VALUES(?,CURDATE(),?,?,?,current_timestamp)",
                cr.getCno(),cr.getSc(),cr.getAc(),cr.getEno());

    }
}
