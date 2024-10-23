package repository.custom.impl;

import dto.Order;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import repository.custom.OrderDao;

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
}
