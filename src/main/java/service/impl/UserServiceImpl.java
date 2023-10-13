package service.impl;

import base.service.BaseServiceImpl;
import entity.users.User;
import repository.UserRepository;
import service.UserService;
import util.ApplicationContext;

import java.util.Optional;

public class UserServiceImpl<T extends User>
        extends BaseServiceImpl<T,Long, UserRepository<T>>
        implements UserService<T> {
    public UserServiceImpl(UserRepository<T> repository) {
        super(repository);
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        return repository.isUserExistsByEmail(email);
    }

    @Override
    public Optional<T> getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }


}
