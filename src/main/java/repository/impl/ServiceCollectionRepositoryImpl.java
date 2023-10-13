package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.Services.ServiceCollection;
import repository.ServiceCollectionRepository;

import javax.persistence.EntityManager;

public class ServiceCollectionRepositoryImpl extends BaseRepositoryImpl<ServiceCollection,Long> implements ServiceCollectionRepository {
    public ServiceCollectionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<ServiceCollection> getEntityClass() {
        return ServiceCollection.class;
    }
}
