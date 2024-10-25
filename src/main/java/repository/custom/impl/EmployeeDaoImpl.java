package repository.custom.impl;

import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.EmployeeDao;
import util.HibernateUtil;

import java.util.List;

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
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        List<EmployeeEntity> userList = session.createQuery("FROM employee").list();
        ObservableList<EmployeeEntity> list= FXCollections.observableArrayList();
        session.close();
        userList.forEach(userEntity -> {
            list.add(userEntity);
        });
        return list;
    }


    @Override
    public boolean update(EmployeeEntity employee) {
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        return null;
    }

    @Override
    public String getLatestId() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("SELECT id FROM employee ORDER BY id DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        session.close();
        return id;
    }


}
