package repository.impl;

import base.repository.BaseRepositoryImpl;
import com.sun.xml.bind.v2.model.core.ID;
import entity.Services.SubServiceCollection;
import repository.SubServiceCollectionRepository;

import javax.persistence.EntityManager;

public class SubServiceCollectionRepositoryImpl extends BaseRepositoryImpl<SubServiceCollection,Long> implements SubServiceCollectionRepository {
    public SubServiceCollectionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<SubServiceCollection> getEntityClass() {
        return SubServiceCollection.class;
    }

}
