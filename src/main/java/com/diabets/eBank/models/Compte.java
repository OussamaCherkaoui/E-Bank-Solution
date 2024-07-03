package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroCompte;
    @Column
    private String typeCompte;
    @Column
    private Integer solde;
    @Column
    private Date dateOuverture;
    @Column
    private String nomProprietaire;
    @Column
    private Integer motDePass;
    @OneToOne(mappedBy = "compte")
    private CompteFerme compteFerme;
    @OneToOne(mappedBy = "compte")
    private Transaction transaction;
    @OneToMany(mappedBy = "compte", fetch = FetchType.EAGER)
    private List<Carte> cartes = new ArrayList<>();
    @OneToMany(mappedBy = "compte", fetch = FetchType.EAGER)
    private List<Beneficiaire> beneficiaires = new ArrayList<>();
    @OneToOne(mappedBy = "compteBeneficiaire")
    private Beneficiaire beneficiaire;
    @ManyToOne
    @JoinColumn(name = "idBanque")
    private Banque banque;
}
