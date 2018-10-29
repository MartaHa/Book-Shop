package pl.martaha.books.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.martaha.books.entity.User;
import pl.martaha.books.repository.RoleRepository;
import pl.martaha.books.repository.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {


    private UserService userService;
    private UserRepository repository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp(){
        repository = mock(UserRepository.class);
        userService = new UserServiceImpl(repository,roleRepository,bCryptPasswordEncoder);
    }


    @Test
    public void findByUsername() {

        //given

        User testUser1 = new User();
        testUser1.setFirstName("Anna");
        testUser1.setUsername("login1");

        User testUser2 = new User();
        testUser2.setFirstName("Mariusz");
        testUser2.setUsername("login2");

        when(repository.findByUsername("login1")).thenReturn(testUser1);
        when(repository.findByUsername("login2")).thenReturn(testUser2);


        //when
        User user3 = userService.findByUsername("login1");
        User user4 = userService.findByUsername("login2");

        //then
        assertEquals(user3.getFirstName(), "Anna");
        assertEquals(user4.getFirstName(), "Mariusz");
    }


//    @Test
//    public void saveUser() {
//    }
}