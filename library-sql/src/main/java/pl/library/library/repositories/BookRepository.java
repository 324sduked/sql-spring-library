package pl.library.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.library.library.entities.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    Optional<Book> findById(Long id);

    List<Book> findAllByAuthor(String author);

    int countBookByTitle(String title);

}
