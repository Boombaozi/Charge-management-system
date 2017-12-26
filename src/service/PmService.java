package service;

import domain.*;

import java.util.List;

public interface PmService {
    public List<Pm> findAllPm1();
    public void addPm1(Pm pm);
    public void deletePm1(Pm  pm);
    public void updatePm1(Pm pm);



}
