package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;
import util.RepositoryType;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public boolean addEmployee(Employee employee) {

        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);

        EmployeeDao employeeDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);

        employeeDao.save(entity);
        System.out.println("Service layer" +employee);
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(String id) {

        return false;
    }

    @Override
    public Employee searchEmployee(String id) {
        return null;
    }

    @Override
    public ObservableList<Employee> getAll() {
        EmployeeEntity entity = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);
        return null;
    }

}
