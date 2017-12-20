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
        return qr.query("select * from etype", new BeanListHandler<Etype>(Etype.class));
    }
}
