package com.diabets.eBank;

import com.diabets.eBank.Repository.CartRepository;
import com.diabets.eBank.Repository.CompteRepository;
import com.diabets.eBank.models.*;
import com.diabets.eBank.services.CartService;
import com.diabets.eBank.services.CompteService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CartTest {
    @Autowired
    CartService cartService;
    @Autowired
    CompteService compteService;
    @MockBean
    private CartRepository cartRepository;

    @BeforeEach
    public void setUp() {
        // Vous pouvez effectuer des initialisations ici si nécessaire
    }

    @Test
    void testCreerCart() {
        String numeroCompte="754479715281537967189930";
        Compte compte = compteService.getCompteByNumero(numeroCompte);

        Carte carte = new Carte();
        carte.setTypeCarte("debut");
        carte.setCompte(compte);

        when(cartRepository.save(carte)).thenReturn(carte);

        Optional<Carte> cartCreer = Optional.ofNullable(cartService.creerCart(carte));;
        assertTrue(cartCreer.isPresent());
    }

    @Test
    void testGetCartByNumeroCartAndCodePin() {
        String numeroCart="72351977680590";
        Integer codePin = 9502;
        Carte carte = new Carte();
        when(cartRepository.findByNumeroCarteAndCodePin(numeroCart,codePin)).thenReturn(Optional.of(carte));


        Optional<Carte> foundCart = cartService.getCartByNumeroCartAndCodePin(numeroCart,codePin);
        assertTrue(foundCart.isPresent());
    }

    @Test
    @Transactional
    void testActiverCart() {
        String numeroCart="72351977680590";
        cartService.activerCart(numeroCart);
        Carte carte = new Carte();
        when(cartRepository.findByNumeroCarte(numeroCart)).thenReturn(carte);

        Carte foundCart = cartService.getCartByNumeroCart(numeroCart);
        assertEquals("activer",foundCart.getEtat());
    }

    @Test
    @Transactional
    void testDesactiverCart() {
        String numeroCart="72351977680590";
        cartService.desactiverCart(numeroCart);
        Carte carte = new Carte();
        when(cartRepository.findByNumeroCarte(numeroCart)).thenReturn(carte);

        Carte foundCart = cartService.getCartByNumeroCart(numeroCart);
        assertEquals("desactiver",foundCart.getEtat());
    }


    @Test
    void testBloqueCart() {
        String numeroCart="72351977680590";
        String raison = "j aurai pas besoin";
        cartService.bloqueCart(numeroCart,raison);
        Carte carte = new Carte();
        when(cartRepository.findByNumeroCarte(numeroCart)).thenReturn(carte);

        Carte foundCart = cartService.getCartByNumeroCart(numeroCart);
        assertEquals(true,foundCart.getEstBloque());
    }



}
