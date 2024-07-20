package com.diabets.eBank.controllers;

import com.diabets.eBank.models.User;
import com.diabets.eBank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User saveUser = userService.saveUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
    @GetMapping("/logIn/{userName}/{passWord}")
    public ResponseEntity<User> logIn(@PathVariable String userName,@PathVariable String passWord) {
        return ResponseEntity.of(userService.getUserByUserNameAndPassWord(userName,passWord));
    }

}
