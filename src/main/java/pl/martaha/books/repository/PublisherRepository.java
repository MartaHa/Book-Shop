package pl.martaha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.martaha.books.entity.Publisher;

public interface PublisherRepository extends JpaRepository <Publisher, Long> {
}
