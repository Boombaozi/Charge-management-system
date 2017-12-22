package dao;
import domain.*;
import java.sql.SQLException;
import java.util.List;
public interface EmployeesDao {
    public List<Employees> findAllEmployees() throws SQLException;

    public void addEmployees(Employees e) throws SQLException;

    public void deleteEmployees(Employees e) throws SQLException;

    public void updateEmployees(Employees e) throws SQLException;

    public Employees findEmployeesById(String eno) throws SQLException;
}
