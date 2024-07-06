package com.diabets.eBank.controllers;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.services.CartService;
import com.diabets.eBank.services.CompteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/compte/cart")
public class cartController {
    @Autowired
    CompteService compteService;
    @Autowired
    CartService cartService;
    @PostMapping("/creerCart")
    public ResponseEntity<Carte> saveCompte(@RequestBody Carte carte) {
        String numeroCarte = cartService.generateUniqueCartNumber();
        Integer codePin = cartService.generateCodePinCart();
        carte.setNumeroCarte(numeroCarte);
        carte.setCodePin(codePin);
        carte.setDateExpiration(LocalDate.now().plusYears(5));
        carte.setEtat("activer");
        carte.setEstBloque(false);
        Carte saveCarte = cartService.creerCart(carte);
        return new ResponseEntity<>(saveCarte, HttpStatus.CREATED);
    }

}
