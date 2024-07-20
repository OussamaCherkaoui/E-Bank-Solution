package com.diabets.eBank.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CompteDTO {
    private String numeroCompte;
    private String typeCompte;
    private Double solde;
    private LocalDate dateOuverture;
    private Boolean estFerme;
    // Mot de passe and other sensitive information are omitted for security
}