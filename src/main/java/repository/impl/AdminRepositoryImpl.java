package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.users.Admin;
import repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends UserRepositoryImpl<Admin> implements AdminRepository {
    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
