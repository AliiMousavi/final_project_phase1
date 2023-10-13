package repository;

import base.repository.BaseRepository;
import entity.users.User;

import java.util.Optional;

public interface UserRepository<T extends User>  extends BaseRepository<T , Long> {
    boolean  isUserExistsByEmail(String email);
    Optional<T> getUserByEmail(String email);
}
