package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    private String numeroCompte;
    @Column
    private String typeCompte;
    @Column
    private Double solde;
    @Column
    private LocalDate dateOuverture;
    @Column
    private Integer motDePass;
    @Column
    private Boolean estFerme;
    @OneToOne(mappedBy = "compte")
    private CompteFerme compteFerme;
    @OneToOne(mappedBy = "compte")
    private Transaction transaction;
    @OneToMany(mappedBy = "compte", fetch = FetchType.EAGER)
    private List<Carte> cartes = new ArrayList<>();
    @OneToMany(mappedBy = "compte", fetch = FetchType.EAGER)
    private List<Beneficiaire> beneficiaires = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idBanque")
    private Banque banque;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
