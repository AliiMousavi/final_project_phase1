package service.impl;

import base.service.BaseServiceImpl;
import entity.Services.ServiceCollection;
import repository.ServiceCollectionRepository;
import service.ServiceCollectionService;

public class ServiceCollectionServiceImpl
        extends BaseServiceImpl<ServiceCollection,Long, ServiceCollectionRepository>
        implements ServiceCollectionService {
    public ServiceCollectionServiceImpl(ServiceCollectionRepository repository) {
        super(repository);
    }
}
