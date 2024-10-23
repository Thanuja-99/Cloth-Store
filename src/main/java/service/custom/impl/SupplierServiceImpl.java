package service.custom.impl;

import dto.Supplier;
import javafx.collections.ObservableList;
import service.custom.SupplierService;

public class SupplierServiceImpl implements SupplierService {
    @Override
    public boolean addSupliers(Supplier supplier) {
        return false;
    }

    @Override
    public boolean updateSupliers(Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupliers(String id) {
        return false;
    }

    @Override
    public Supplier searchSupliers(String id) {
        return null;
    }

    @Override
    public ObservableList<Supplier> getAll() {
        return null;
    }
}
