package service.custom;

import dto.Product;
import entity.ProductEntity;
import javafx.collections.ObservableList;

public interface ProductService {

    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(String id);
    Product searchProduct(String id);
    ObservableList<Product> getAll();

}
