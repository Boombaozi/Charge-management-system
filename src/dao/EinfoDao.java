package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;
public interface EinfoDao {
    public List<Etype> findAllEtype() throws SQLException;

    public void addEtype(Etype etype) throws SQLException;

    public void deleteEtype(Etype etype) throws SQLException;

    public void updateEtype(Etype etype) throws SQLException;

    public Etype findEtypeById(String id) throws SQLException;

}