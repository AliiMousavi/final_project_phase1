package service;

import base.service.BaseService;
import com.sun.xml.bind.v2.model.core.ID;
import entity.Services.SubServiceCollection;

public interface SubServiceCollectionService extends BaseService<SubServiceCollection,Long> {

    SubServiceCollection updateBasePrice(Long subServiceId, int newBasePrice);
    SubServiceCollection updateCaption(Long subServiceId, String newCaption);
}
