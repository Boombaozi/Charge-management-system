package dao;
import java.sql.SQLException;
import java.util.List;
public interface PmDao {
    public List<PmDao> findAllPm() throws SQLException;

    public void addPm(PmDao p) throws SQLException;

    public void deletePm(PmDao p) throws SQLException;

    public void updatePm(PmDao p) throws SQLException;

    public PmDao findPmById(String cno) throws SQLException;
}
