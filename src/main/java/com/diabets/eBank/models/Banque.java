package com.diabets.eBank.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBanque;
    @Column
    private String nomBanque;
    @Column
    private String adress;
    @Column
    private Integer telephone;
    @Column
    private String email;
    @OneToMany(mappedBy = "banque", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Compte> comptes = new ArrayList<>();
}
