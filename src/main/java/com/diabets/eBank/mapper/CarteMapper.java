package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.CarteDTO;
import com.diabets.eBank.models.Carte;

public class CarteMapper {
    public static CarteDTO toDTO(Carte carte) {
        return CarteDTO.builder()
                .numeroCarte(carte.getNumeroCarte())
                .codePin(carte.getCodePin())
                .dateExpiration(carte.getDateExpiration())
                .typeCarte(carte.getTypeCarte())
                .etat(carte.getEtat())
                .estBloque(carte.getEstBloque())
                .build();
    }

    public static Carte toEntity(CarteDTO carteDTO) {
        return Carte.builder()
                .numeroCarte(carteDTO.getNumeroCarte())
                .codePin(carteDTO.getCodePin())
                .dateExpiration(carteDTO.getDateExpiration())
                .typeCarte(carteDTO.getTypeCarte())
                .etat(carteDTO.getEtat())
                .estBloque(carteDTO.getEstBloque())
                .build();
    }
}