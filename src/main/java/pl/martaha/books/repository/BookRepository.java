package pl.martaha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.martaha.books.entity.Book;

public interface BookRepository extends JpaRepository <Book, Long> {
}
