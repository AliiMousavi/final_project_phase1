package repository.impl;

import entity.users.Admin;
import entity.users.Customer;
import repository.AdminRepository;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends UserRepositoryImpl<Customer> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
