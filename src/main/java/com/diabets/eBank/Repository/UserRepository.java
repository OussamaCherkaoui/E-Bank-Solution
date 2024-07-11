package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserNameAndPassWord(String userName,String passWord);
    User findByUserName(String userName);
}
