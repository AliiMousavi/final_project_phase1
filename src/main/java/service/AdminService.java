package service;

import base.service.BaseService;
import entity.Services.ServiceCollection;
import entity.Services.SubServiceCollection;
import entity.users.Admin;
import entity.users.Expert;

import java.util.Collection;
import java.util.List;

public interface AdminService extends UserService<Admin> {
    ServiceCollection addServiceCollection(ServiceCollection serviceCollection);
    SubServiceCollection addSubServiceCollection(SubServiceCollection subServiceCollection);
    Collection<ServiceCollection> getAllServiceCollection();
    Collection<SubServiceCollection> getAllSubServiceCollection();
    SubServiceCollection updateBasePrice(Long subServiceId, int newBasePrice);
    SubServiceCollection updateCaption(Long subServiceId, String newCaption);
    SubServiceCollection addExpertToSubServiceCollection(Expert expert,SubServiceCollection SubServiceCollection);
    SubServiceCollection deleteExpertToSubServiceCollection(Expert expert,SubServiceCollection SubServiceCollection);
    Expert confirmExpertbyId(Long id);
}
