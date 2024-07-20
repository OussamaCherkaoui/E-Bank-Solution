package com.diabets.eBank.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class BanqueDTO {
    private Integer idBanque;
    private String nomBanque;
    private String adress;
    private Integer telephone;
    private String email;
}
