package repository.impl;

import entity.users.Customer;
import entity.users.Expert;
import repository.CustomerRepository;
import repository.ExpertRepository;

import javax.persistence.EntityManager;

public class ExpertRepositoryImpl  extends UserRepositoryImpl<Expert> implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
