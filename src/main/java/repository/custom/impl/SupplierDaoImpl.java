package repository.custom.impl;

import dto.Supplier;
import entity.SupplierEntity;
import javafx.collections.ObservableList;
import repository.custom.SupplierDao;

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
}
