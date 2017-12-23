package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;
public interface CrDao {
    public List<Cr> findAllCr() throws SQLException;

    public void addCr(Cr cr) throws SQLException;

    public void deleteCr(Cr cr) throws SQLException;

    public void updateCr(Cr cr) throws SQLException;

    public Cr findCrById(Cr cr) throws SQLException;

}
