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
    @Query(value = "update Compte set est_ferme=true  where numero_compte = :numeroCompte", nativeQuery = true)
    void fermeCompte(@Param("numeroCompte") String numeroCompte);

    Compte findByNumeroCompte(String numero);
    boolean existsByNumeroCompte(String numero);

    @Query(value = "select solde from compte inner join carte on compte.numero_compte=carte.numero_compte where carte.numero_carte = :numeroCart", nativeQuery = true)
    Integer getSoldeByNumeroCart(@Param("numeroCart") String numeroCart);
    @Query(value = "select numero_compte from carte where carte.numero_carte = :numeroCart", nativeQuery = true)
    String getnumeroCompteByNumeroCart(@Param("numeroCart") String numeroCart);
}
