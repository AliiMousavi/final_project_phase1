package service.impl;

import base.service.BaseServiceImpl;
import entity.Services.ServiceCollection;
import entity.Services.SubServiceCollection;
import entity.users.Admin;
import repository.AdminRepository;
import service.AdminService;
import util.ApplicationContext;

import java.util.Collection;

public class AdminServiceImpl extends UserServiceImpl<Admin> implements AdminService {
    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public ServiceCollection addServiceCollection(ServiceCollection serviceCollection) {
        return ApplicationContext.getServiceCollectionService().saveOrUpdate(serviceCollection);

    }

    @Override
    public SubServiceCollection addSubServiceCollection(SubServiceCollection subServiceCollection) {
        return ApplicationContext.getSubServiceCollectionService().saveOrUpdate(subServiceCollection);
    }

    @Override
    public Collection<ServiceCollection> getAllServiceCollection() {
        return ApplicationContext.getServiceCollectionService().findAll();
    }

    @Override
    public Collection<SubServiceCollection> getAllSubServiceCollection() {
        return ApplicationContext.getSubServiceCollectionService().findAll();
    }

    @Override
    public SubServiceCollection updateBasePrice(Long subServiceId, int newBasePrice) {
        return ApplicationContext.getSubServiceCollectionService().updateBasePrice(subServiceId, newBasePrice);
    }

    @Override
    public SubServiceCollection updateCaption(Long subServiceId, String newCaption) {
        return ApplicationContext.getSubServiceCollectionService().updateCaption(subServiceId,newCaption);
    }

}
