package dao;

import domain.Cr;
import domain.Etype;
import domain.client;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    @Override
    public List<client> findAllClient() throws SQLException {

            QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
            return qr.query("select * from dbwork.client order by etno", new BeanListHandler<client>(client.class));

    }

    @Override
    public void addClient(client client) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.client VALUES(?,?,?,?,?,current_timestamp)",
                client.getCno(),client.getCname(),client.getAddr(),client.getCtel(),client.getMoney());

    }

    @Override
    public void deleteClient(client client) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.client where cno=?",client.getCno());
    }

    @Override
    public void updateClient(client client) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update etype set cno=?,cname=?,addr=?,ctel=?,money=? where cno=?",
            client.getCno(),client.getCname(),client.getAddr(),client.getAddr(),client.getCtel(),client.getMoney()
               );
    }

    @Override
    public client findClientById(client client) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.client where cno=?",new BeanHandler<client>(client.class),client.getCno());


    }
}
