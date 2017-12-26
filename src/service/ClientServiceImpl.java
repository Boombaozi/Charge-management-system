package service;

import dao.ClientDaoImpl;
import domain.client;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService{

ClientDaoImpl clientDao= new ClientDaoImpl();
    @Override
    public List<client> findAllClient1() {

        try {
            return clientDao.findAllClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addClient1(client client) {
        try {
            clientDao.addClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient1(client client) {
        try {
            clientDao.deleteClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient1(client client) {
        try {
            clientDao.updateClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
