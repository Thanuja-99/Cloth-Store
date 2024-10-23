package repository.custom.impl;

import dto.Product;
import entity.ProductEntity;
import javafx.collections.ObservableList;
import repository.custom.ProductDao;

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
}
