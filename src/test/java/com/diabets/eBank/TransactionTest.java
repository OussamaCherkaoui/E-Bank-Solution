package com.diabets.eBank;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.Transaction;
import com.diabets.eBank.services.CartService;
import com.diabets.eBank.services.CompteService;
import com.diabets.eBank.services.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionTest {
    @Autowired
    CartService cartService;
    @Autowired
    CompteService compteService;
    @Autowired
    TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        // Vous pouvez effectuer des initialisations ici si nécessaire
    }

    @Test
    void testTransfere() {
        String numeroCompte="754479715281537967189930";
        String numeroCart ="72351977680590";
        Transaction transaction =new Transaction();
        transaction.setMontant(2000);
        transaction.setCompte(compteService.getCompteByNumero(numeroCompte));
        transaction.setCarte(cartService.getCartByNumeroCart(numeroCart));


        Optional<Transaction> transactionEffectuer = transactionService.transfer(transaction);
        assertTrue(transactionEffectuer.isPresent());
    }
}
