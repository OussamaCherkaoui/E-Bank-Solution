package com.diabets.eBank.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CarteBloqueDTO {
    private Integer idCarteBloque;
    private String raison;
    private LocalDate dateBlocage;
    private String numeroCarte; // Only the card number to avoid circular reference
}
