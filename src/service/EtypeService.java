package service;

import domain.Etype;
import domain.User;

import java.util.List;

public interface EtypeService {

    public List<Etype> findAllEtype1();
    public void addEtype1(Etype etype);
    public void deleteEtype1(Etype etype);
    public void updateEtype1(Etype etype);
}