package com.diabets.eBank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Carte")
public class Carte {
    @Id
    private String numeroCarte;
    @Column
    private Integer codePin;
    @Column
    private LocalDate dateExpiration;
    @Column
    private String typeCarte;
    @Column
    private String etat;
    @Column(columnDefinition = "boolean default false")
    private Boolean estBloque;
    @OneToMany(mappedBy = "carte", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();
    @OneToOne(mappedBy = "carte")
    private CarteBloque carteBloque;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "numeroCompte")
    private Compte compte;
}
