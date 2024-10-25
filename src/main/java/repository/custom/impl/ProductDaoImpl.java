package repository.custom.impl;

import dto.Product;
import entity.EmployeeEntity;
import entity.ProductEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import repository.custom.ProductDao;
import util.HibernateUtil;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public boolean save(ProductEntity product) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(ProductEntity.class,id));
        session.getTransaction().commit();
        return true;
    }

    @Override
    public ObservableList<ProductEntity> getAll() {

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.getTransaction();
        List<ProductEntity> userList = session.createQuery("FROM product").list();
        ObservableList<ProductEntity> list= FXCollections.observableArrayList();
        session.close();
        userList.forEach(userEntity -> {
            list.add(userEntity);
        });
        return list;
    }

    @Override
    public boolean update(ProductEntity product) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public ProductEntity search(String id) {

        Session session = HibernateUtil.getSession();
        ProductEntity productEntity = null;

        try {

            Long productId = Long.parseLong(id);

            productEntity = session.get(ProductEntity.class, productId);

            if (productEntity == null) {
                System.out.println("No Item found with ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Expected a numeric value: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productEntity;
    }

}
