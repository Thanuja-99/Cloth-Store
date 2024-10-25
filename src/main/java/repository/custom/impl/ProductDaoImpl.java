package repository.custom.impl;

import dto.Product;
import entity.ProductEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.ProductDao;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

    @Override
    public boolean save(ProductEntity product) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<ProductEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(ProductEntity product) {
        return false;
    }

    @Override
    public ProductEntity search(String id) {
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
