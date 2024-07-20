package com.diabets.eBank.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class BeneficiaireDTO {
    private Integer idBenificiaire;
    private String numeroCompteBeneficiaire;
}