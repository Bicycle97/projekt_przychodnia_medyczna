package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {

    EntityManagerFactory entityManagerFactory;

    private MyEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static MyEntityManagerFactory getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final  MyEntityManagerFactory instance = new MyEntityManagerFactory();
    }

    public EntityManagerFactory getEmFactory() {
        return entityManagerFactory;
    }

    public void setEmFactory(EntityManagerFactory emFactory) {
        this.entityManagerFactory = emFactory;
    }
}
