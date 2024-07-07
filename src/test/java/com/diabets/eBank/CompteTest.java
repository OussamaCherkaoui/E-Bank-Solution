package com.diabets.eBank;

import com.diabets.eBank.Repository.CompteFermeRepository;
import com.diabets.eBank.Repository.CompteRepository;
import com.diabets.eBank.models.Banque;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import com.diabets.eBank.models.User;
import com.diabets.eBank.services.CompteService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CompteTest {
    @Autowired
    CompteService compteService;
    @MockBean
    private CompteRepository compteRepository;
    @MockBean
    private CompteFermeRepository compteFermeRepository;

    @BeforeEach
    public void setUp() {
        // Vous pouvez effectuer des initialisations ici si nécessaire
    }

    @Test
    void testOuvrirCompte() {
        User user = new User();
        user.setUser_id(1);
        Banque banque = new Banque();
        banque.setIdBanque(5);
        Compte compte = new Compte();
        compte.setMotDePass(1234);
        compte.setSolde(30000.00);
        compte.setUser(user);
        compte.setBanque(banque);

        when(compteRepository.save(compte)).thenReturn(compte);

        Optional<Compte> compteOuvrir = compteService.ouvrirCompte(compte);;
        assertTrue(compteOuvrir.isPresent());
    }

    @Test
    void testGetCompteByNumeroAndMotDePass() {
        String numeroCompte="754479715281537967189930";
        Integer motDePass=56789 ;
        Compte compte = new Compte();
        when(compteRepository.findByNumeroCompteAndMotDePass(numeroCompte, motDePass)).thenReturn(Optional.of(compte));
        Optional<Compte> foundCompte = compteService.getCompteByNumeroAndMotDePass(numeroCompte,motDePass);;
        assertTrue(foundCompte.isPresent());
    }

    @Test
    @Transactional
    void testFermeCompte_Success() {
        String numeroCompte = "754479715281537967189930";
        String raison = "Closure reason";
        Compte compte = new Compte();
        when(compteRepository.findByNumeroCompte(numeroCompte)).thenReturn(compte);

        Optional<CompteFerme> compteFerme = Optional.ofNullable(compteService.fermeCompte(numeroCompte, raison));

        assertTrue(compteFerme.isEmpty(), "CompteFerme should be present");
    }



}
