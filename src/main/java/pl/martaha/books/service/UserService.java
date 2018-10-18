package pl.martaha.books.service;

import pl.martaha.books.entity.User;

public interface UserService {

    User findByUsername(String username);
    void saveUser(User user, String role);
}
