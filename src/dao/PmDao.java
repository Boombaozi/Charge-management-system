package dao;
import domain.Pm;

import java.sql.SQLException;
import java.util.List;
public interface PmDao {
    public List<Pm> findAllPm() throws SQLException;

    public void addPm(Pm p) throws SQLException;

    public void deletePm(Pm p) throws SQLException;

    public void updatePmsign(Pm p) throws SQLException;

    public Pm findPmById(Pm p) throws SQLException;
}
