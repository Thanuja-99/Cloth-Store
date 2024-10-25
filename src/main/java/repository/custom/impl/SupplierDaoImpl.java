package repository.custom.impl;


import entity.SupplierEntity;
import javafx.collections.ObservableList;


import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.SupplierDao;
import util.HibernateUtil;


public class SupplierDaoImpl implements SupplierDao {

    @Override
    public boolean save(SupplierEntity supplier) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<SupplierEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(SupplierEntity supplier) {
        return false;
    }

    @Override
    public SupplierEntity search(String id) {
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
