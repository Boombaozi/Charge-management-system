package service;

import domain.Etype;
import domain.User;

import java.util.List;

public interface EtypeService {

    public List<Etype> findAllEtype();
    public void addEtype(Etype etype);

}