package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;
import util.RepositoryType;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDaoImpl= DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);

    @Override
    public boolean addEmployee(Employee employee) {

            EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);
            EmployeeDao employeeDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);

            // Attempt to save the employee and return true if successful
            try {
                employeeDao.save(entity);
                return true; // Indicate that the employee was added successfully
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging
                return false; // Indicate that the employee was not added
            }


    }

    @Override
    public boolean updateEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);
        EmployeeDao employeeDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);
        return employeeDao.update(entity); // Ensure you call update here
    }

    @Override
    public boolean deleteEmployee(String id) {
        return employeeDaoImpl.delete(id);
    }

    @Override
    public Employee searchEmployee(String id) {
        EmployeeEntity employeeEntity = employeeDaoImpl.search(id);
        return new ModelMapper().map(employeeEntity,Employee.class);
    }

    @Override
    public ObservableList<Employee> getAll() {

        EmployeeDao employeeDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);
        ObservableList<EmployeeEntity> list = employeeDao.getAll();
        ObservableList<Employee> userList = FXCollections.observableArrayList();

        list.forEach(userEntity -> {
            userList.add(new ModelMapper().map(userEntity, Employee.class));
        });
        return userList;
    }

}
