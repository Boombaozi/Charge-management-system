package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    public List<client> findAllClient() throws SQLException;

    public void addClient(client client) throws SQLException;

    public void deleteClient(client client) throws SQLException;

    public void updateClient(client client) throws SQLException;

    public client findClientById(String cno) throws SQLException;


}
