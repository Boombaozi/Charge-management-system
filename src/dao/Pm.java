package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;
public interface Pm {
    public List<Pm> findAllPm() throws SQLException;

    public void addPm(Pm p) throws SQLException;

    public void deletePm(Pm p) throws SQLException;

    public void updatePm(Pm p) throws SQLException;

    public Pm findPmById(String cno) throws SQLException;
}
