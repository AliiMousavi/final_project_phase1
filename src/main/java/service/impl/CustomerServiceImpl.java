package service.impl;

import base.service.BaseServiceImpl;
import entity.Order;
import entity.users.Customer;
import entity.users.Expert;
import repository.CustomerRepository;
import service.CustomerService;
import util.ApplicationContext;
import util.Validator;

public class CustomerServiceImpl
        extends BaseServiceImpl<Customer,Long, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }


    @Override
    public Customer ChangePasswordByID(String password, Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("expert not found with id: " + id));
        if(Validator.isValidPassword(password))
            customer.setPassword(password);
        else
            throw new RuntimeException("is not valid password!");

        return repository.saveOrUpdate(customer);
    }

    @Override
    public Order Ordering(Order order) {
        return ApplicationContext.getOrderService().saveOrUpdate(order);
    }
}
