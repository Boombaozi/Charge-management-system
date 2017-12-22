package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    public List<client> findAllEtype() throws SQLException;

    public void addClient(client client) throws SQLException;

    public void delete(client client) throws SQLException;

    public void updateClient(client client) throws SQLException;

    public client findClientById(String id) throws SQLException;


}
