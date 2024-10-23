package service.custom;

import dto.Order;
import dto.Supplier;
import javafx.collections.ObservableList;

public interface OrderService {
    boolean addItem(Order order);
    boolean updateItem(Order order);
    boolean deleteItem(String id);
    ObservableList<Order> getAll();
}
