package com.diabets.eBank.services;

import com.diabets.eBank.Repository.CartBloqueRepository;
import com.diabets.eBank.Repository.CartRepository;
import com.diabets.eBank.Repository.CompteRepository;
import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.CarteBloque;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CartBloqueRepository cartBloqueRepository;

    private static final int CART_NUMBER_LENGTH = 14;


    public Carte creerCart(Carte cart){
        return cartRepository.save(cart);
    }

    public Optional<Carte> getCartByNumeroCart(Integer numeroCart){
        return cartRepository.findById(numeroCart);
    }
    public List<Carte> getAllCartByNumeroCompte(String numeroCompte){
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte);
        return cartRepository.findAllByCompte(compte);
    }
    public void activerCart(String numeroCart)
    {
        cartRepository.activerCart(numeroCart);
    }
    public void desactiverCart(String numeroCart)
    {
        cartRepository.desactiverCart(numeroCart);
    }
    public CarteBloque bloqueCart(String numeroCart,String raison){
        cartRepository.bloqueCart(numeroCart);
        Carte cart = cartRepository.findByNumeroCarte(numeroCart);
        CarteBloque carteBloque = new CarteBloque();
        carteBloque.setRaison(raison);
        carteBloque.setDateBlocage(LocalDate.now());
        carteBloque.setCarte(cart);
        carteBloque.setRaison(raison);
        return cartBloqueRepository.save(carteBloque);
    }

    public String generateUniqueCartNumber() {
        String cartNumber;
        do {
            cartNumber = generateRandomCartNumber();
        } while (cartRepository.existsByNumeroCarte(cartNumber));
        return cartNumber;
    }

    private String generateRandomCartNumber() {
        Random random = new Random();
        StringBuilder cartNumber = new StringBuilder(CART_NUMBER_LENGTH);
        for (int i = 0; i < CART_NUMBER_LENGTH; i++) {
            cartNumber.append(random.nextInt(10));
        }
        return cartNumber.toString();
    }
    public Integer generateCodePinCart() {
        Random random = new Random();
        int codePin = 0;
        for (int i = 0; i < 4; i++) {
            codePin = codePin * 10 + random.nextInt(10);
        }
        return codePin;
    }
}
