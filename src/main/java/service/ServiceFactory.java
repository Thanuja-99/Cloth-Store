package service;

import dto.Employee;
import service.custom.impl.EmployeeServiceImpl;
import service.custom.impl.OrderServiceImpl;
import service.custom.impl.ProductServiceImpl;
import service.custom.impl.SupplierServiceImpl;
import util.ServiceType;

public class ServiceFactory {

    private  static  ServiceFactory instance;
    private ServiceFactory(){}

    public static  ServiceFactory getInstance(){
    return  instance==null? instance=new ServiceFactory():instance;
    }

//    type casting
    public <T extends SuperService>T getServiceType(ServiceType type){

    switch (type){
        case EMPLOYEE:return (T) new EmployeeServiceImpl();
        case SUPPLIER:return (T) new SupplierServiceImpl();
        case PRODUCT:return (T) new ProductServiceImpl();
        case ORDER:return  (T) new OrderServiceImpl();
    }
    return null;
    }
}
