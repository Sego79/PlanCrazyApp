package com.example.plan_crazy_app_back_office.connection;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory ENTITY_MANAGER;

    private PersistenceManager() {

    }

    public static EntityManagerFactory getEntityManager() {
        if (ENTITY_MANAGER == null) {
            ENTITY_MANAGER = Persistence.createEntityManagerFactory("myPU");
        }
        return ENTITY_MANAGER;
    }
}
