package service;

import com.sun.deploy.util.SessionState;
import domain.*;

import java.util.List;

public interface ClientService {

    public List<client> findAllClient1();
    public void addClient1(client client);
    public void deleteClient1(client client);
    public void updateClient1(client client);



}
