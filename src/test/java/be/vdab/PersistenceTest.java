package be.vdab;

import org.junit.*;

import java.util.List;
import static junit.framework.TestCase.assertEquals;


public class PersistenceTest extends AbstractPersistenceTest {

    //private Logger logger = LoggerFactory.getLogger(be.vdab.BookPersistenceTest.class);


    @Test
    public void testOurLogic() {
        //logger.debug("Saying hello from the logging infrastructure");

        BookRepository bookRepository = new BookRepositoryBean(entityManager);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(6, books.size());
    }

    @Test
    public void findAllBooksReturnsExactlySixBooks() throws Exception {             //bij Unit testen mogen Exceptions gewoon gethrowed worden
        List <Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals(6, books.size());
    }
}
