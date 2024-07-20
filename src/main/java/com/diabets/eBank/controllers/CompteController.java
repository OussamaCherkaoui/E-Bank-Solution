package com.diabets.eBank.controllers;

import com.diabets.eBank.Repository.BeneficiaireRepository;
import com.diabets.eBank.dto.BeneficiaireDTO;
import com.diabets.eBank.dto.CompteDTO;
import com.diabets.eBank.mapper.BeneficiaireMapper;
import com.diabets.eBank.mapper.CompteMapper;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compte")
@CrossOrigin(origins = "http://localhost:4200/")
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
    public ResponseEntity<CompteDTO> getUserByNameAndPassWord(@PathVariable String numeroCompte,@PathVariable Integer mot_de_pass) {
        Optional<Compte> compte = compteService.getCompteByNumeroAndMotDePass(numeroCompte, mot_de_pass);
        if (compte.isPresent()) {
            CompteDTO compteDTO = CompteMapper.toDTO(compte.get());
            return ResponseEntity.ok(compteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/fermeCompte/{numeroCompte}/{raison}")
    public ResponseEntity<?> fermerCompte(@PathVariable String numeroCompte,@PathVariable String raison) {
        CompteFerme saveCompteFerme = compteService.fermeCompte(numeroCompte,raison);
        return new ResponseEntity<>(saveCompteFerme, HttpStatus.CREATED);
    }
    @PostMapping("/ajouterBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}")
    public ResponseEntity<BeneficiaireDTO> ajouterBeneficiaire(@PathVariable String numeroCompte,@PathVariable String numeroCompteBeneficiaire) {
        Compte compteProprietaire = compteService.getCompteByNumero(numeroCompte);
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setCompte(compteProprietaire);
        beneficiaire.setNumeroCompteBeneficiaire(numeroCompteBeneficiaire);

        BeneficiaireDTO beneficiaireDTO = beneficiaireService.ajouterBeneficiaire(beneficiaire);

        return new ResponseEntity<>(beneficiaireDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/supprimerBeneficiaire/{numeroCompte}/{numeroCompteBeneficiaire}")
    public ResponseEntity<?> supprimerBeneficiaire(@PathVariable String numeroCompte,@PathVariable String numeroCompteBeneficiaire) {
        Compte compteProprietaire = compteService.getCompteByNumero(numeroCompte);
        Beneficiaire beneficiaire = beneficiaireService.deleteBeneficiaireByCompteAndNumeroCompteBeneficiaire(compteProprietaire, numeroCompteBeneficiaire);
        if (beneficiaire != null) {
            BeneficiaireDTO beneficiaireDto = BeneficiaireMapper.toDTO(beneficiaire);
            return ResponseEntity.ok(beneficiaireDto);
        } else {
            return null;
        }
    }

    @GetMapping("/getAllBeneficiaire/{numeroCompte}")
    public ResponseEntity<List<BeneficiaireDTO>> ajouterBeneficiaire(@PathVariable String numeroCompte) {
        List<Beneficiaire> beneficiaires = beneficiaireService.getAllBeneficiaireByNumeroCompte(numeroCompte);
        List<BeneficiaireDTO> beneficiaireDTOs = beneficiaires.stream()
                .map(BeneficiaireMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(beneficiaireDTOs, HttpStatus.OK);
    }
}
