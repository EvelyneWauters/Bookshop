package be.vdab;

import org.junit.*;

import java.util.Date;
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

    @Test
    public void testingHowTheTransparantUpdatesWorks() throws Exception {
        Book book = new Book("Roald Dahl", "0000009", "De griezels");
        entityManager.persist(book);
        book.setAuthor("lala");
        Book bookdb = entityManager.find(Book.class, book.getId());
        assertEquals(bookdb.getAuthor(), book.getAuthor());
    }

    @Test
    public void testRemove() throws Exception   {
        Book book = new Book("Junot Diaz", "0000010", "The Wondrous Brief Life Of Oscar Wao");
        entityManager.persist(book);
        entityManager.remove(book);
        Book bookdb = entityManager.find(Book.class, book.getId());
        assertEquals(bookdb, null);
    }

    @Test
    public void testInputDate() throws Exception    {
        Date dob = new Date(1988,01,11);
        Passenger p = new Passenger(dob,"ikke");

    }
}
