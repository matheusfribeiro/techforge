// src/main/java/com/techforge/persistence/jpa/JpaUtil.java
package com.techforge.persistance.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("techforge.jpa");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void inTransaction(Consumer<EntityManager> work) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            work.accept(entityManager);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
