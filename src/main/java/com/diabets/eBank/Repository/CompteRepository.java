package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Optional<Compte> findByNumeroCompteAndMotDePass(String numero,Integer motdePass);

    @Modifying
    @Query(value = "update Compte c set c.est_ferme=true  where c.numero_compte = :numeroCompte", nativeQuery = true)
    void fermeCompte(@Param("numeroCompte") String numeroCompte);

    Compte findByNumeroCompte(String numero);
    boolean existsByNumeroCompte(String numero);
}
