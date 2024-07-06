package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "CompteFerme")
public class CompteFerme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroCompteFerme;
    @Column
    private LocalDate dateFermeture;
    @Column
    private String raison;
    @OneToOne
    @JoinColumn(name = "numeroCompte")
    private Compte compte;
}
