package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        var emf = Persistence.createEntityManagerFactory("jpa-test");
        var em = emf.createEntityManager();

        // sample save
        // save(em);
        // remove(em);

        System.out.println("Products saved");

        em.close();
        emf.close();
    }

    private static void remove(EntityManager em) {
        var product = em.find(Product.class, 3L);
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }

    private static void save(EntityManager em) {
        em.getTransaction().begin();
        em.persist(new Product("Rice", BigDecimal.valueOf(4)));
        em.persist(new Product("Potato", BigDecimal.valueOf(2)));
        em.persist(new Product("Beans", BigDecimal.valueOf(3)));
        em.getTransaction().commit();
    }
}