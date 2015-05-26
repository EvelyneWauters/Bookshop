import be.vdab.blackbooks.Book;
import be.vdab.blackbooks.BookRepository;
import be.vdab.blackbooks.BookRepositoryBean;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestMain {
    // Obtain the EntityManager as described earlier
    private EntityManager em;

    @Test
    public void testOurLogic() {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        BookRepository bookRepository = new BookRepositoryBean(entityManager);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(6, books.size());
    }


}
