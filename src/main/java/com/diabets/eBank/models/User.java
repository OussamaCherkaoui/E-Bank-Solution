package com.diabets.eBank.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(name = "user_name")
    private String userName;
    @Column
    private String cin;
    @Column
    private String email;
    @Column
    private String passWord;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Compte> comptes = new ArrayList<>();
}
