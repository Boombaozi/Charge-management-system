package service;

import dao.EtypeDao;
import dao.EtypeDaoImpl;
import domain.Etype;
import domain.User;

import java.sql.SQLException;
import java.util.List;

public class EtypeServiceImpl implements EtypeService {

    EtypeDaoImpl etypeDao = new EtypeDaoImpl();

    @Override
    public List<Etype> findAllEtype() {



        try {
            return etypeDao.findAllEtype();
        } catch (SQLException A) {
            A.printStackTrace();
            System.out.println(A);
        }
        return null;
    }

    @Override
    public void addEtype(Etype etype) {

        try {
            etypeDao.addEtype(etype);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}