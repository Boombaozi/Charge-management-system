package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;
public interface EinfoDao {
    public List<Einfo> findAllEinfo() throws SQLException;

    public void addEinfo(Einfo einfo) throws SQLException;

    public void deleteEinfo(Einfo einfo) throws SQLException;

    public void updateEinfo(Einfo einfo) throws SQLException;

    public Einfo findEinfoById(Einfo cno) throws SQLException;

}
