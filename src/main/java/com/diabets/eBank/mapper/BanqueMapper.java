package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.BanqueDTO;
import com.diabets.eBank.models.Banque;

public class BanqueMapper {
    public static BanqueDTO toDTO(Banque banque) {
        return BanqueDTO.builder()
                .idBanque(banque.getIdBanque())
                .nomBanque(banque.getNomBanque())
                .adress(banque.getAdress())
                .telephone(banque.getTelephone())
                .email(banque.getEmail())
                .build();
    }

    public static Banque toEntity(BanqueDTO banqueDTO) {
        return Banque.builder()
                .idBanque(banqueDTO.getIdBanque())
                .nomBanque(banqueDTO.getNomBanque())
                .adress(banqueDTO.getAdress())
                .telephone(banqueDTO.getTelephone())
                .email(banqueDTO.getEmail())
                .build();
    }
}
