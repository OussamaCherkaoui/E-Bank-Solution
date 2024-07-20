package com.diabets.eBank.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class UserDTO {
    private Integer user_id;
    private String userName;
    private String cin;
    private String email;
    // Note: Exclure `passWord` pour des raisons de sécurité
    private List<String> comptes; // Liste des numéros de comptes (ou autres attributs simples)
}