package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.Compte;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Carte, Integer> {
     List<Carte> findAllByCompte(Compte compte);

    @Modifying
    @Transactional
    @Query(value = "update Carte set etat='activer'  where numero_Carte = :numeroCart", nativeQuery = true)
    void activerCart(String numeroCart);
    @Modifying
    @Transactional
    @Query(value = "update Carte set etat='desactiver'  where numero_Carte = :numeroCart", nativeQuery = true)
    void desactiverCart(String numeroCart);
    @Modifying
    @Transactional
    @Query(value = "update Carte set est_bloque=true  where numero_carte = :numeroCart", nativeQuery = true)
    void bloqueCart(String numeroCart);
    Optional<Carte> findByNumeroCarteAndCodePin(String numero, Integer codePin);
    Carte findByNumeroCarte(String numero);
    boolean existsByNumeroCarte(String numero);

    @Query(value = "select code_pin from Carte where numero_carte = :numeroCart", nativeQuery = true)
    Integer getCodePinbyNumeroCart(String numeroCart);
}
