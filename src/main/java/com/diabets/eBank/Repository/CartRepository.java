package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Carte, Integer> {
     List<Carte> findAllByCompte(Compte compte);

     @Query(value = "update Carte c set c.etat='activer'  where c.numeroCarte = :numeroCart", nativeQuery = true)
    void activerCart(String numeroCart);

    @Query(value = "update Carte c set c.etat='desactiver'  where c.numeroCarte = :numeroCart", nativeQuery = true)
    void desactiverCart(String numeroCart);

    @Query(value = "update Carte c set c.estBloque=true  where c.numeroCarte = :numeroCart", nativeQuery = true)
    void bloqueCart(String numeroCart);

    Carte findByNumeroCarte(String numero);
    boolean existsByNumeroCarte(String numero);
}
