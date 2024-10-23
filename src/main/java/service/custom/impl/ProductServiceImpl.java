package service.custom.impl;

import dto.Product;
import javafx.collections.ObservableList;
import service.custom.ProductService;

public class ProductServiceImpl implements ProductService {
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        return false;
    }

    @Override
    public Product searchProduct(String id) {
        return null;
    }

    @Override
    public ObservableList<Product> getAll() {
        return null;
    }
}
