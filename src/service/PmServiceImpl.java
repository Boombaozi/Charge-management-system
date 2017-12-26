package service;

import dao.PmDaoImpl;
import domain.Pm;

import java.sql.SQLException;
import java.util.List;

public class PmServiceImpl implements PmService{

    PmDaoImpl pmDao=new PmDaoImpl();
    @Override
    public List<Pm> findAllPm1() {


        try {
            return pmDao.findAllPm();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addPm1(Pm pm) {

        try {
            pmDao.addPm(pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deletePm1(Pm pm) {
        try {
            pmDao.deletePm(pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePm1(Pm pm) {
        try {
            pmDao.updatePm(pm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
