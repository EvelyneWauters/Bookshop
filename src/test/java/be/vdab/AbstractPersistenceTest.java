package be.vdab;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jeansmits on 26/05/15.
 */
public abstract class AbstractPersistenceTest {
    // Obtain the EntityManager as described earlier
    private static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    //fixtures voor unit testing
    @BeforeClass
    public static void initalizeEntityManagerFactory()    {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("BlackBooks");      //checken met de naam in de persistence.xml naar de persistence-unit name (databaseconfiguratie, meerdere db's, meerdere persistence-units)
    }

    @AfterClass
    public static void destroyEntityManagerFactory()   {
        entityManagerFactory.close();
    }

    //voor elke test apart
    @Before
    public void initalizeEntityManager()    {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    //na elke test apart
    @After
    public void destroyEntityManager()  {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
