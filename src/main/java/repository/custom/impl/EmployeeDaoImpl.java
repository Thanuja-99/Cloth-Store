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
            System.out.println("repository :" + employee);

            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.persist(employee); // Use persist to add a new entity
                transaction.commit(); // Commit the transaction if successful
                return true; // Indicate success
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback(); // Roll back the transaction in case of error
                }
                e.printStackTrace(); // Log the exception for debugging
                return false; // Indicate failure
            } finally {
                session.close(); // Always close the session
            }
        }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(EmployeeEntity.class,id));
        session.getTransaction().commit();
        return true;
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
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(employee); // Use merge to update the detached entity
            transaction.commit(); // Commit the transaction
            return true; // Indicate success
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Roll back if there’s an error
            }
            e.printStackTrace(); // Print the stack trace for debugging
            return false; // Indicate failure
        } finally {
            session.close(); // Close the session
        }
    }



    @Override
    public EmployeeEntity search(String id) {
        Session session = HibernateUtil.getSession();
        EmployeeEntity employeeEntity = null;

        try {
            // Attempt to parse ID to Long
            Long employeeId = Long.parseLong(id);
            // Retrieve EmployeeEntity by primary key
            employeeEntity = session.get(EmployeeEntity.class, employeeId);

            if (employeeEntity == null) {
                System.out.println("No employee found with ID: " + id); // Debug message
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Expected a numeric value: " + id);
        } catch (Exception e) {
            e.printStackTrace(); // Log any other unexpected exceptions
        } finally {
            session.close();
        }
        return employeeEntity; // Return the found employee or null if not found
    }

}
