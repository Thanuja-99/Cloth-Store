package repository.custom.impl;

import dto.Order;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.OrderDao;
import util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity order) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<OrderEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(OrderEntity order) {
        return false;
    }

    @Override
    public OrderEntity search(String id) {
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
