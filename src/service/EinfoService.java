package service;

import domain.*;

import java.util.List;

public interface EinfoService {

    public List<Einfo> findAllEinfo1();
    public void addEinfo1(Einfo einfo);
    public void deleteEinfo1(Einfo einfo);
    public void updateEinfo1(Einfo einfo);
    public  void addEinfo2(Einfo einfo);
}
