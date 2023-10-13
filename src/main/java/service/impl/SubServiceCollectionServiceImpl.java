package service.impl;

import base.service.BaseServiceImpl;
import com.sun.xml.bind.v2.model.core.ID;
import entity.Services.SubServiceCollection;
import repository.SubServiceCollectionRepository;
import service.SubServiceCollectionService;

import java.util.Optional;

public class SubServiceCollectionServiceImpl
        extends BaseServiceImpl<SubServiceCollection,Long, SubServiceCollectionRepository>
        implements SubServiceCollectionService {
    public SubServiceCollectionServiceImpl(SubServiceCollectionRepository repository) {
        super(repository);
    }

    @Override
    public SubServiceCollection updateBasePrice(Long subServiceId, int newBasePrice) {

        SubServiceCollection subService = repository.findById(subServiceId)
                .orElseThrow(() -> new IllegalArgumentException("Sub-service not found with id: " + subServiceId));

        subService.setBasePrice(newBasePrice);
        return repository.saveOrUpdate(subService);
    }

    @Override
    public SubServiceCollection updateCaption(Long subServiceId, String newCaption) {
        SubServiceCollection subService = repository.findById(subServiceId)
                .orElseThrow(() -> new IllegalArgumentException("Sub-service not found with id: " + subServiceId));

        subService.setCaption(newCaption);
        return repository.saveOrUpdate(subService);
    }
}
