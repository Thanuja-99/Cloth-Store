package repository;

import repository.custom.impl.EmployeeDaoImpl;
import repository.custom.impl.OrderDaoImpl;
import repository.custom.impl.ProductDaoImpl;
import repository.custom.impl.SupplierDaoImpl;
import util.RepositoryType;

public class DaoFactory {

    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance==null?instance=new DaoFactory():instance;
    }

    public <T extends SuperDao>T getRepositoryType(RepositoryType repositoryType){
        switch (repositoryType){
            case EMPLOYEE:return (T) new EmployeeDaoImpl();
            case ORDER:return (T) new OrderDaoImpl();
            case PRODUCT:return (T) new ProductDaoImpl();
            case SUPPLIER:return (T) new SupplierDaoImpl();
        }
    return null;
    }
}