package dao;

import domain.Etype;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class EtypeDaoImpl implements EtypeDao{


    @Override
    public List<Etype> findAllEtype() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.etype order by etno", new BeanListHandler<Etype>(Etype.class));

    }

    @Override
    public void addEtype(Etype etype) throws SQLException {

            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


            qr.update("INSERT INTO dbwork.etype VALUES(?,?,?,current_timestamp)",etype.getEtno(),etype.getEtname(),etype.getPrice());

        }

    @Override
    public void deleteEtype(Etype etype) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.etype where etno=?",etype.getEtno());
    }

    @Override
    public void updateEtype(Etype etype) throws SQLException {

            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            qr.update("update etype set etname=?,price=? where etno=?",
                    etype.getEtname(),etype.getPrice(),etype.getEtno());


        }

    @Override
    public Etype findEtypeById(String id) throws SQLException {
        return null;
    }


}



