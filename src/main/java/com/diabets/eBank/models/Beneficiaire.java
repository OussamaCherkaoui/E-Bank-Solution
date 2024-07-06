package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "Beneficiaire")
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenificiaire;
    @ManyToOne
    @JoinColumn(name = "numeroCompte")
    private Compte compte;
    @Column
    private String numeroCompteBeneficiaire;
}
