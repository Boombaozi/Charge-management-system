package service;

import dao.EmployeesDao;
import dao.EmployeesDaoImpl;
import domain.Employees;

import java.sql.SQLException;
import java.util.List;

public class EServiceImpl implements EService {

    EmployeesDaoImpl employeesDao = new EmployeesDaoImpl();

    @Override
    public List<Employees> findAllE1() {

        try {
            return employeesDao.findAllEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addE1(Employees e) {
        try {
            employeesDao.addEmployees(e);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void deleteE1(Employees e) {
        try {
            employeesDao.deleteEmployees(e);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void updateE1(Employees e) {
        try {
            employeesDao.updateEmployees(e);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
