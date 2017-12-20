package dao;

import domain.Etype;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Util;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public interface EtypeDao {


    public List<Etype> findAllEtype()throws SQLException;


}
