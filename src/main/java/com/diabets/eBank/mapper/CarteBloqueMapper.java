package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.CarteBloqueDTO;
import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.CarteBloque;

public class CarteBloqueMapper {
    public static CarteBloqueDTO toDTO(CarteBloque carteBloque) {
        return CarteBloqueDTO.builder()
                .idCarteBloque(carteBloque.getIdCarteBloque())
                .raison(carteBloque.getRaison())
                .dateBlocage(carteBloque.getDateBlocage())
                .numeroCarte(carteBloque.getCarte() != null ? carteBloque.getCarte().getNumeroCarte() : null)
                .build();
    }

    public static CarteBloque toEntity(CarteBloqueDTO carteBloqueDTO) {
        CarteBloque carteBloque = CarteBloque.builder()
                .idCarteBloque(carteBloqueDTO.getIdCarteBloque())
                .raison(carteBloqueDTO.getRaison())
                .dateBlocage(carteBloqueDTO.getDateBlocage())
                .build();

        // Create a dummy Carte object with just the numeroCarte for the association
        if (carteBloqueDTO.getNumeroCarte() != null) {
            carteBloque.setCarte(Carte.builder().numeroCarte(carteBloqueDTO.getNumeroCarte()).build());
        }

        return carteBloque;
    }
}
