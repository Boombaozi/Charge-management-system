package service;

import domain.*;

import java.util.List;

public interface EService {

    public List<Employees> findAllE1();
    public void addE1(Employees e);
    public void deleteE1(Employees e);
    public void updateE1(Employees e);

}
