package service.custom.impl;

import dto.Employee;
import dto.Product;
import entity.EmployeeEntity;
import entity.ProductEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import repository.custom.ProductDao;
import service.custom.ProductService;
import util.RepositoryType;

public class ProductServiceImpl implements ProductService {

    ProductDao productDaoImpl= DaoFactory.getInstance().getRepositoryType(RepositoryType.PRODUCT);


    @Override
    public boolean addProduct(Product product) {

       ProductEntity entity= new ModelMapper().map(product, ProductEntity.class);
       ProductDao productDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.PRODUCT);
        try {
            productDao.save(entity);
            return true; // Indicate that the employee was added successfully
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return false; // Indicate that the employee was not added
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        ProductEntity entity = new ModelMapper().map(product, ProductEntity.class);
        ProductDao productDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.PRODUCT);
        return productDao.update(entity);
    }

    @Override
    public boolean deleteProduct(String id) {
        return productDaoImpl.delete(id);
    }

    @Override
    public Product searchProduct(String id) {

        ProductEntity productEntity = productDaoImpl.search(id);
        return new ModelMapper().map(productEntity, Product.class);
    }

    @Override
    public ObservableList<Product> getAll() {

        ProductDao productDao = DaoFactory.getInstance().getRepositoryType(RepositoryType.PRODUCT);
        ObservableList<ProductEntity> list = productDao.getAll();
        ObservableList<Product> userList = FXCollections.observableArrayList();

        list.forEach(userEntity -> {
            userList.add(new ModelMapper().map(userEntity, Product.class));
        });
        return userList;
    }
}
