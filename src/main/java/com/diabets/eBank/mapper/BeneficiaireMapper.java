package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.BeneficiaireDTO;
import com.diabets.eBank.models.Beneficiaire;

public class BeneficiaireMapper {
    public static BeneficiaireDTO toDTO(Beneficiaire beneficiaire) {
        return BeneficiaireDTO.builder()
                .idBenificiaire(beneficiaire.getIdBenificiaire())
                .numeroCompteBeneficiaire(beneficiaire.getNumeroCompteBeneficiaire())
                .build();
    }

    public static Beneficiaire toEntity(BeneficiaireDTO beneficiaireDTO) {
        return Beneficiaire.builder()
                .idBenificiaire(beneficiaireDTO.getIdBenificiaire())
                .numeroCompteBeneficiaire(beneficiaireDTO.getNumeroCompteBeneficiaire())
                .build();
    }
}
