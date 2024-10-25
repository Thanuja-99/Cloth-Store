package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.SuperDao;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;
import util.RepositoryType;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDaoImpl= DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);

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

        EmployeeDao employeeDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);
        ObservableList<EmployeeEntity> list = employeeDao.getAll();
        ObservableList<Employee> userList = FXCollections.observableArrayList();

        list.forEach(userEntity -> {
            userList.add(new ModelMapper().map(userEntity, Employee.class));
        });
        return userList;
    }

    @Override
    public boolean deleteEmployeeById(String text) {
        return false;
    }

    @Override
    public String generateEmployeeId() {
        String lastEmployeeId = employeeDaoImpl.getLatestId();
        if (lastEmployeeId==null){
            return "E001";
        }
        int number = Integer.parseInt(lastEmployeeId.split("E")[1]);
        number++;
        return String.format("E%03d", number);
    }

}
