package service;

import base.service.BaseService;
import entity.users.User;

import java.util.Optional;

public interface UserService<T extends User> extends BaseService<T,Long> {
    boolean  isUserExistsByEmail(String email);
    Optional<T> getUserByEmail(String email);
}