package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.CompteDTO;
import com.diabets.eBank.models.Compte;

public class CompteMapper {
    public static CompteDTO toDTO(Compte compte) {
        return CompteDTO.builder()
                .numeroCompte(compte.getNumeroCompte())
                .typeCompte(compte.getTypeCompte())
                .solde(compte.getSolde())
                .dateOuverture(compte.getDateOuverture())
                .estFerme(compte.getEstFerme())
                .build();
    }

    public static Compte toEntity(CompteDTO compteDTO) {
        return Compte.builder()
                .numeroCompte(compteDTO.getNumeroCompte())
                .typeCompte(compteDTO.getTypeCompte())
                .solde(compteDTO.getSolde())
                .dateOuverture(compteDTO.getDateOuverture())
                .estFerme(compteDTO.getEstFerme())
                .build();
    }
}
