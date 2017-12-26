package service;

import dao.*;
import domain.Einfo;
import domain.Etype;
import domain.Pm;

import java.sql.SQLException;
import java.util.List;

public class EinfoServiceImpl implements EinfoService {


    EinfoDaoImpl einfoDao = new EinfoDaoImpl();


    public List<Einfo> findAllEinfo1() {
        try {
            return einfoDao.findAllEinfo();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void addEinfo1(Einfo einfo) {
        try {
            einfoDao.addEinfo(einfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteEinfo1(Einfo einfo) {
        try {
            einfoDao.deleteEinfo(einfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEinfo1(Einfo einfo) {
        try {
            einfoDao.updateEinfo(einfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEinfo2(Einfo einfo) {
        Pm pm =new Pm();
        pm.setCno(einfo.getCno());
        pm.setDate(einfo.getDate());



    }
}