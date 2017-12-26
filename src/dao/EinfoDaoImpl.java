package dao;

import domain.Einfo;
import domain.Etype;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class EinfoDaoImpl implements EinfoDao {



    @Override
    public List<Einfo> findAllEinfo() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select cno,date,etno,enum as eenum,create_at from dbwork.einfo", new BeanListHandler<Einfo>(Einfo.class));

    }

    @Override
    public void addEinfo(Einfo einfo) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.einfo VALUES(?,?,?,?,current_timestamp)",
                einfo.getCno(),einfo.getDate(),einfo.getEtno(),einfo.getEenum());

    }

    @Override
    public void deleteEinfo(Einfo einfo) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.einfo where cno=? and date=?",
                einfo.getCno(),einfo.getDate());
    }

    @Override
    public void updateEinfo(Einfo einfo) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update dbwork.einfo set etno=?,enum=? where cno=? and date=?",
                einfo.getEtno(),einfo.getEenum(),einfo.getCno(),einfo.getDate());

    }

    @Override
    public Einfo findEinfoById(Einfo cno) throws SQLException {
        return null;
    }
}
