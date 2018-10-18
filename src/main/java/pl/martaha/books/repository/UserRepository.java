package pl.martaha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.martaha.books.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByUsername(String username);
}
