package com.diabets.eBank;

import com.diabets.eBank.models.User;
import com.diabets.eBank.services.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Vous pouvez effectuer des initialisations ici si nécessaire
    }

    @Test
    void testGetUserByUserNameAndPassWord() {
        Optional<User> foundUser = userService.getUserByUserNameAndPassWord("oussama", "oo@123");
        assertTrue(foundUser.isPresent());
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUserName("testName");
        user.setPassWord("test@123");

        User savedUser = userService.saveUser(user);

        Optional<User> foundUser = userService.getUserByUserNameAndPassWord(user.getUserName(), user.getPassWord());
        assertTrue(foundUser.isPresent());
    }

}
