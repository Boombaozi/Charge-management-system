package service;


import dao.CrDaoImpl;
import domain.Cr;

import java.sql.SQLException;
import java.util.List;

public class CrServiceImpl implements CrService {

    CrDaoImpl crDao=new CrDaoImpl();

    @Override
    public List<Cr> findAllCr1() {
        try {
            return crDao.findAllCr();
        } catch (SQLException A) {
            A.printStackTrace();

            return null;
        }

    }

    @Override
    public void addCr1(Cr cr) {

        try {
           crDao.addCr(cr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCr1(Cr cr) {
        try {
            crDao.deleteCr(cr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCr1(Cr cr) {

    }
}
