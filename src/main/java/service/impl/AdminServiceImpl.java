package service.impl;

import base.service.BaseServiceImpl;
import entity.Services.ServiceCollection;
import entity.Services.SubServiceCollection;
import entity.enums.ExpertStatus;
import entity.users.Admin;
import entity.users.Expert;
import repository.AdminRepository;
import service.AdminService;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @Override
    public SubServiceCollection addExpertToSubServiceCollection(Expert expert ,SubServiceCollection SubServiceCollection ) {
        SubServiceCollection byId = ApplicationContext.getSubServiceCollectionService().findById(SubServiceCollection.getId())
                .orElseThrow(() -> new IllegalArgumentException("Sub-service not found with id: " + SubServiceCollection.getId()));
        List<Expert> experts = new ArrayList<>();
        experts.add(expert);
        byId.setExperts(experts);
       return ApplicationContext.getSubServiceCollectionService().saveOrUpdate(byId);
    }

    @Override
    public SubServiceCollection deleteExpertToSubServiceCollection(Expert expert, SubServiceCollection SubServiceCollection) {
        SubServiceCollection.getExperts().remove(expert);
       return ApplicationContext.getSubServiceCollectionService().saveOrUpdate(SubServiceCollection);
    }

    @Override
    public Expert confirmExpertbyId(Long id) {
        Expert byId = ApplicationContext.getExpertService().findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sub-service not found with id: " + id));;
        byId.setExpertStatus(ExpertStatus.ACCEPTED);
        return ApplicationContext.getExpertService().saveOrUpdate(byId);
    }

}
