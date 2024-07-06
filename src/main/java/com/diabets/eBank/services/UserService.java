package com.diabets.eBank.services;

import com.diabets.eBank.Repository.UserRepository;
import com.diabets.eBank.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
    public Optional<User> getUserByUserNameAndPassWord(String userName,String passWord){
        return userRepository.findByUserNameAndPassWord(userName,passWord);
    }
}
