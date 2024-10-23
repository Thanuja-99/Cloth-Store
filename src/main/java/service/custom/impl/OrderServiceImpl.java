package service.custom.impl;

import dto.Order;
import javafx.collections.ObservableList;
import service.custom.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public boolean addItem(Order order) {
        return false;
    }

    @Override
    public boolean updateItem(Order order) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public ObservableList<Order> getAll() {
        return null;
    }
}
