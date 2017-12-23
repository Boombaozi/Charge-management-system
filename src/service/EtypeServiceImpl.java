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
    public List<Etype> findAllEtype1() {



        try {
            return etypeDao.findAllEtype();
        } catch (SQLException A) {
            A.printStackTrace();
            System.out.println(A);
        }
        return null;
    }

    @Override
    public void addEtype1(Etype etype) {

        try {
            etypeDao.addEtype(etype);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteEtype1(Etype etype) {
        try {
            etypeDao.deleteEtype(etype);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEtype1(Etype etype) {
        try {
            etypeDao.updateEtype(etype);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}