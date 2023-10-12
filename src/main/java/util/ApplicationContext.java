package util;

import config.EntityManagerProvider;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final EntityManager em;

    static {
        em = EntityManagerProvider.getEntityManager();
    }
}
