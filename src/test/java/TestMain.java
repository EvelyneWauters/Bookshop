import be.vdab.blackbooks.Book;
import be.vdab.blackbooks.BookRepository;
import be.vdab.blackbooks.BookRepositoryBean;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestMain {
    // Obtain the EntityManager as described earlier
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    //private Logger logger = LoggerFactory.getLogger(TestMain.class);

    //fixtures voor unit testing
    @BeforeClass
    public static void initalizeEntityManagerFactory()    {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("BlackBooks");
    }

    //voor elke test apart
    @Before
    public void initalizeEntityManager()    {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @AfterClass
    public static void destroyEntityManagerFactory()   {
        entityManagerFactory.close();
    }

    //na elke test apart
    @After
    public void destroyEntityManager()  {
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Test
    public void testOurLogic() {
        //logger.debug("Saying hello from the logging infrastructure");

        BookRepository bookRepository = new BookRepositoryBean(entityManager);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(6, books.size());
    }


}
