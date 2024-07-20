package com.diabets.eBank;

import com.diabets.eBank.dto.BeneficiaireDTO;
import com.diabets.eBank.models.Beneficiaire;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.services.BeneficiaireService;
import com.diabets.eBank.services.CompteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BeneficiaireTest {
    @Autowired
    BeneficiaireService beneficiaireService;
    @Autowired
    CompteService compteService;
    @BeforeEach
    public void setUp() {
        // Vous pouvez effectuer des initialisations ici si nécessaire
    }

    @Test
    public void testAjouterBeneficiaire() {
        String numeroCompte="754479715281537967189930";
        String numeroCompteBeneficiaire="184872323454196311377570";
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setNumeroCompteBeneficiaire(numeroCompteBeneficiaire);
        Compte compte = compteService.getCompteByNumero(numeroCompte);
        beneficiaire.setCompte(compte);


        BeneficiaireDTO beneficiaireSaved = beneficiaireService.ajouterBeneficiaire(beneficiaire);

        assertNotNull(beneficiaireSaved);
        assertEquals(numeroCompteBeneficiaire, beneficiaireSaved.getNumeroCompteBeneficiaire());
    }

    @Test
    public void testsupprimerBeneficiaire() {
        String numeroCompte="754479715281537967189930";
        String numeroCompteBeneficiaire="184872323454196311377570";
        Compte compte = compteService.getCompteByNumero(numeroCompte);


        Beneficiaire beneficiaireDeleted = beneficiaireService.deleteBeneficiaireByCompteAndNumeroCompteBeneficiaire(compte,numeroCompteBeneficiaire);

        assertNotNull(beneficiaireDeleted);
        assertEquals(numeroCompte, beneficiaireDeleted.getCompte().getNumeroCompte());
        assertEquals(numeroCompteBeneficiaire, beneficiaireDeleted.getNumeroCompteBeneficiaire());
    }
}
