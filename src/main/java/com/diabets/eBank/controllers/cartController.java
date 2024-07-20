package com.diabets.eBank.controllers;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.CarteBloque;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.services.CartService;
import com.diabets.eBank.services.CompteService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/compte/cart")
@CrossOrigin(origins = "http://localhost:4200/")
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
    @PostMapping("/activerCart/{numeroCart}")
    public ResponseEntity<String> activerCart(@PathVariable String numeroCart) {
        cartService.activerCart(numeroCart);
        return new ResponseEntity<>("cart Activer", HttpStatus.OK);
    }
    @PostMapping("/desactiverCart/{numeroCart}")
    public ResponseEntity<String> desactiverCart(@PathVariable String numeroCart) {
        cartService.desactiverCart(numeroCart);
        return new ResponseEntity<>("cart desactiver", HttpStatus.OK);
    }
    @PostMapping("/bloqueCart/{numeroCart}/{raison}")
    public ResponseEntity<CarteBloque> bloqueCart(@PathVariable String numeroCart, @PathVariable String raison) {
        CarteBloque carteBloque=cartService.bloqueCart(numeroCart,raison);
        return new ResponseEntity<>(carteBloque, HttpStatus.OK);
    }
    @GetMapping("/getPin/{numeroCart}")
    public ResponseEntity<Integer> getCodePinForCart(@PathVariable String numeroCart)
    {
        Integer codePin = cartService.getCodePinByNumeroCart(numeroCart);
        return new ResponseEntity<>(codePin, HttpStatus.OK);
    }
    @GetMapping("/connectCart/{numeroCart}/{codePin}")
    public ResponseEntity<?> connectCart(@PathVariable String numeroCart,@PathVariable Integer codePin)
    {
        Optional<Carte> carte = cartService.getCartByNumeroCartAndCodePin(numeroCart,codePin);
        return new ResponseEntity<>(carte, HttpStatus.OK);
    }

}
