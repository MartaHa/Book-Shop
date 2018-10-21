package pl.martaha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.martaha.books.entity.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
