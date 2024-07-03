package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "CarteBloque")
public class CarteBloque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarteBloque;
    @Column
    private String raison;
    @Column
    private Date dateBlocage;
    @OneToOne
    @JoinColumn(name = "numeroCarte")
    private Carte carte;
}
