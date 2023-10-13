package service;

import base.service.BaseService;
import entity.Order;
import entity.users.Customer;

public interface CustomerService extends BaseService<Customer,Long> {
    Customer ChangePasswordByID(String password,Long id);
    Order Ordering(Order order);
}
