package be.vdab;

import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks();
}
