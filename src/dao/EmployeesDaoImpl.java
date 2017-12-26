package dao;

import domain.Employees;
import domain.Etype;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class EmployeesDaoImpl implements EmployeesDao {
    @Override
    public List<Employees> findAllEmployees() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from dbwork.employees;", new BeanListHandler<Employees>(Employees.class));



    }

    @Override
    public void addEmployees(Employees e) throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        qr.update("INSERT INTO dbwork.employees VALUES(?,?,?,?,current_timestamp)",
                e.getEno(),e.getName(),e.getSex(),e.getEtel());

    }

    @Override
    public void deleteEmployees(Employees e) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from dbwork.employees where eno=?",e.getEno());
    }

    @Override
    public void updateEmployees(Employees e) throws SQLException {

        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("UPDATE dbwork.employees SET name = ?, sex = ?, etel = ? WHERE eno = ?;",
                e.getName(),e.getSex(),e.getEtel(),e.getEno());
    }

    @Override
    public Employees findEmployeesById(String eno) throws SQLException {
        return null;
    }
}
