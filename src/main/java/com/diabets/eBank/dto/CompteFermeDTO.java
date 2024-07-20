package com.diabets.eBank.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CompteFermeDTO {
    private Integer numeroCompteFerme;
    private LocalDate dateFermeture;
    private String raison;
    private String numeroCompte;  // Référence simple au compte
}