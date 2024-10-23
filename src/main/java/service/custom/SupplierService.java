package service.custom;

import dto.Supplier;
import javafx.collections.ObservableList;

public interface SupplierService {

    boolean addSupliers(Supplier supplier);
    boolean updateSupliers(Supplier supplier);
    boolean deleteSupliers(String id);
    Supplier searchSupliers(String id);
    ObservableList<Supplier> getAll();
}
