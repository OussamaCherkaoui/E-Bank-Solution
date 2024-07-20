package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.CompteFermeDTO;
import com.diabets.eBank.models.CompteFerme;

public class CompteFermeMapper {

    public static CompteFermeDTO toDTO(CompteFerme compteFerme) {
        return CompteFermeDTO.builder()
                .numeroCompteFerme(compteFerme.getNumeroCompteFerme())
                .dateFermeture(compteFerme.getDateFermeture())
                .raison(compteFerme.getRaison())
                .numeroCompte(compteFerme.getCompte().getNumeroCompte()) // Référence simple
                .build();
    }

    public static CompteFerme toEntity(CompteFermeDTO compteFermeDTO) {
        CompteFerme compteFerme = CompteFerme.builder()
                .numeroCompteFerme(compteFermeDTO.getNumeroCompteFerme())
                .dateFermeture(compteFermeDTO.getDateFermeture())
                .raison(compteFermeDTO.getRaison())
                .build();
        // Associer le compte doit être géré séparément dans le service
        return compteFerme;
    }
}

