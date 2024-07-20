package com.diabets.eBank.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class TransactionDTO {
    private Integer idTransaction;
    private Integer montant;
    private LocalDateTime dateTransaction;
    private String typeTransaction;
    private String description;
    private String numeroCarte;  // Référence simple à la carte
    private String numeroCompte; // Référence simple au compte
}
