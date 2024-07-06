package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Beneficiaire;
import com.diabets.eBank.models.Compte;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Integer> {

    @Query(value = "SELECT b.* FROM Beneficiaire b WHERE b.numero_compte = :numeroCompte AND b.numero_compte_beneficiaire = :numeroCompteBeneficiaire",nativeQuery = true)
    Beneficiaire findBeneficiaireByCompteAndCompteBeneficiaire(@Param("numeroCompte") String numeroCompte, @Param("numeroCompteBeneficiaire") String numeroCompteBeneficiaire);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Beneficiaire WHERE numero_compte = :numeroCompte AND numero_compte_beneficiaire = :numeroCompteBeneficiaire", nativeQuery = true)
    void deleteBeneficiaire(@Param("numeroCompte") String numeroCompte, @Param("numeroCompteBeneficiaire") String numeroCompteBeneficiaire);
}
