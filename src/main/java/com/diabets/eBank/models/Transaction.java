package com.diabets.eBank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;
    @Column
    private Integer montant;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:MM")
    private LocalDateTime dateTransaction;
    @Column
    private String typeTransaction;
    @Column
    private String description;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "numeroCarte")
    private Carte carte;
    @OneToOne
    @JoinColumn(name = "numeroCompte")
    private Compte compte;
}
