package br.unipar.programacaointernet.servicecep.servicecep.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    private EntityManagerUtil() {}

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence
                    .createEntityManagerFactory("HibernateMaven");

            System.out.println("conexão aberto");
        }
        return emf;
    }

    public static EntityManager getManager() {
        if (emf == null) {
            getEntityManagerFactory();
        }

        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            System.out.println("aberto");
        }
        return em;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("conexão fechada!");
        }
    }
}
