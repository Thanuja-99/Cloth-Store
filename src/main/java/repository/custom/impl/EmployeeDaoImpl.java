package repository.custom.impl;

import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.EmployeeDao;
import util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeEntity employee) {
        System.out.println("repository :"+employee);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<EmployeeEntity> getAll() {

        ObservableList<EmployeeEntity> employeeList = FXCollections.observableArrayList();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
        employeeList.addAll(query.getResultList());

        session.getTransaction().commit();
        session.close();
        return employeeList;
    }

    @Override
    public boolean update(EmployeeEntity employee) {
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        return null;
    }


}
