package com.diabets.eBank.controllers;

import com.diabets.eBank.Repository.BeneficiaireRepository;
import com.diabets.eBank.models.Beneficiaire;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import com.diabets.eBank.models.User;
import com.diabets.eBank.services.BeneficiaireService;
import com.diabets.eBank.services.CompteService;
import com.diabets.eBank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/compte")
public class CompteController {
    @Autowired
    CompteService compteService;
    @Autowired
    BeneficiaireService beneficiaireService;

    @PostMapping("/signUpCompte")
    public ResponseEntity<?> saveCompte(@RequestBody Compte compte) {
        String numeroCompte = compteService.generateUniqueAccountNumber();
        compte.setNumeroCompte(numeroCompte);
        compte.setDateOuverture(LocalDate.now());
        Optional<Compte> saveCompte = compteService.ouvrirCompte(compte);
        return new ResponseEntity<>(saveCompte, HttpStatus.CREATED);
    }
    @GetMapping("/logInCompte/{numeroCompte}/{mot_de_pass}")
    public ResponseEntity<Compte> getUserByNameAndPassWord(@PathVariable String numeroCompte,@PathVariable Integer mot_de_pass) {
        return ResponseEntity.of(compteService.getCompteByNumeroAndMotDePass(numeroCompte,mot_de_pass));
    }
    @PostMapping("/fermeCompte/{numeroCompte}/{raison}")
    public ResponseEntity<CompteFerme> fermerCompte(@PathVariable String numeroCompte,@PathVariable String raison) {
        CompteFerme saveCompteFerme = compteService.fermeCompte(numeroCompte,raison);
        return new ResponseEntity<>(saveCompteFerme, HttpStatus.CREATED);
    }
    @PostMapping("/ajouterBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}")
    public ResponseEntity<Beneficiaire> ajouterBeneficiaire(@PathVariable String numeroCompte,@PathVariable String numeroCompteBeneficiaire) {
        Compte compteProprietaire = compteService.getCompteByNumero(numeroCompte);
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setCompte(compteProprietaire);
        beneficiaire.setNumeroCompteBeneficiaire(numeroCompteBeneficiaire);
        Beneficiaire beneficiaireSaved = beneficiaireService.ajouterBeneficiaire(beneficiaire);
        return new ResponseEntity<>(beneficiaireSaved, HttpStatus.CREATED);
    }
    @DeleteMapping("/supprimerBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}")
    public ResponseEntity<?> supprimerBeneficiaire(@PathVariable String numeroCompte,@PathVariable String numeroCompteBeneficiaire) {
        Compte compteProprietaire = compteService.getCompteByNumero(numeroCompte);
        Beneficiaire deletedBeneficiaire = beneficiaireService.deleteBeneficiaireByCompteAndNumeroCompteBeneficiaire(compteProprietaire, numeroCompteBeneficiaire);

        if (deletedBeneficiaire != null) {
            return new ResponseEntity<>(deletedBeneficiaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Échec de la suppression du bénéficiaire.", HttpStatus.NOT_FOUND);
        }
    }
}
