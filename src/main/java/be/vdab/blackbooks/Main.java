package be.vdab.blackbooks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {

    // Set up
    EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("RealDolmenPersistenceUnit");
    EntityManager entityManager =
            entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();



    // Ready to do stuff!



    // Tear down
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();

}
}