package com.example.plan_crazy_app_back_office.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {

    private static EntityManagerFactory ENTITY_MANAGER;
    private static EntityManager em;

    //ON RECUPERE NOTRE ENTITYMANAGER VIA SA METHODE
    public static EntityManager getEntityManager() {

        if (ENTITY_MANAGER == null) {
            ENTITY_MANAGER = Persistence.createEntityManagerFactory("myPU");
        }
        if (em == null || !em.isOpen()) {
            em = ENTITY_MANAGER.createEntityManager();
        }
        return em;
    }

    private PersistenceManager() {

    }

    public static void closeConnection() {
        try {
            ENTITY_MANAGER.close();
        } catch (Exception e) {
            System.err.println("Fermeture de la connexion impossible");
        }
    }


}
