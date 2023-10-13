package service;

import base.service.BaseService;
import entity.users.Expert;

public interface ExpertService extends BaseService<Expert,Long> {
    Expert ChangePasswordByID(String password,Long id);
}
