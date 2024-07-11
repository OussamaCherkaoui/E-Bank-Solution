package com.diabets.eBank.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class AuthenticationRequest{
    private String userName;
    private String passWord;
}
