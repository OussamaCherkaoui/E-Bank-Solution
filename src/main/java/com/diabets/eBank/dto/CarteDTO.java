package com.diabets.eBank.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CarteDTO {
    private String numeroCarte;
    private Integer codePin;
    private LocalDate dateExpiration;
    private String typeCarte;
    private String etat;
    private Boolean estBloque;
}