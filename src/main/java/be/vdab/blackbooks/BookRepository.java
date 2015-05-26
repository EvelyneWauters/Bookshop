package be.vdab.blackbooks;

import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks();
}
