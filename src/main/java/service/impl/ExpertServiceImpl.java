package service.impl;

import base.service.BaseServiceImpl;
import entity.Services.SubServiceCollection;
import entity.users.Expert;
import repository.ExpertRepository;
import service.ExpertService;
import util.Validator;

import java.util.Optional;

public class ExpertServiceImpl
        extends BaseServiceImpl<Expert,Long, ExpertRepository>
        implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public Expert ChangePasswordByID(String password,Long id) {
        Expert expert = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("expert not found with id: " + id));
        if(Validator.isValidPassword(password))
            expert.setPassword(password);
        else
            throw new RuntimeException("is not valid password!");

        return repository.saveOrUpdate(expert);
    }
}
