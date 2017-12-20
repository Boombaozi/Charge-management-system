package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.C3P0Util;

import java.awt.print.Book;
import java.util.List;

public interface EtypeDao {


    public List<User> findAllEtype()throws Exception;


}
