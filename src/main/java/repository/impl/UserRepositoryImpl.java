package repository.impl;

import base.repository.BaseRepositoryImpl;
import entity.users.User;
import repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<T, Long> implements UserRepository<T> {
    public UserRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public boolean isUserExistsByEmail(String email) {
        TypedQuery<Long> query = em.createQuery("select count( u ) from " + getEntityClass().getSimpleName() + " u where u.email= :email", Long.class);
        query.setParameter("email", email);
        Long count = query.getSingleResult();
        return count > 0;
    }
    @Override
    public Optional<T> getUserByEmail(String email) {
        TypedQuery<T> query =
                em.createQuery("from " + getEntityClass().getSimpleName() + " u where u.email= :email "
                        , getEntityClass());

        query.setParameter("email", email);
        try {
            T foundUser = query.getSingleResult();
            return Optional.ofNullable(foundUser);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
