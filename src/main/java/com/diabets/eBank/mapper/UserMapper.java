package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.UserDTO;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .user_id(user.getUser_id())
                .userName(user.getUserName())
                .cin(user.getCin())
                .email(user.getEmail())
                .comptes(user.getComptes().stream()
                        .map(Compte::getNumeroCompte) // Exposez des attributs simples
                        .collect(Collectors.toList()))
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        User user = User.builder()
                .user_id(userDTO.getUser_id())
                .userName(userDTO.getUserName())
                .cin(userDTO.getCin())
                .email(userDTO.getEmail())
                .build();
        // La liste des comptes doit être gérée séparément dans le service
        return user;
    }
}
