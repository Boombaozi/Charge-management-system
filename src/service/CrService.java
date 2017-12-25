package service;

import domain.Cr;
import domain.Etype;

import java.util.List;

public interface CrService {
    public List<Cr> findAllCr1();
    public void addCr1(Cr cr);
    public void deleteCr1(Cr cr);
    public void updateCr1(Cr cr);


}
