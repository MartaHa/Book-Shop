package pl.martaha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.martaha.books.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
