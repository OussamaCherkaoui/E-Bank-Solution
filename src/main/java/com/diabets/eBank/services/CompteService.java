package com.diabets.eBank.services;

import com.diabets.eBank.Repository.CartRepository;
import com.diabets.eBank.Repository.CompteFermeRepository;
import com.diabets.eBank.Repository.CompteRepository;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class CompteService {

    private static final int ACCOUNT_NUMBER_LENGTH = 24;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CompteFermeRepository compteFermeRepository;

    public Optional<Compte> ouvrirCompte(Compte compte) {
        compte.setEstFerme(false);
        return Optional.of(compteRepository.save(compte));
    }
    public Optional<Compte> getCompteByNumeroAndMotDePass(String numero, Integer motDePass) {
        return compteRepository.findByNumeroCompteAndMotDePass(numero,motDePass);
    }

    public Compte getCompteByNumero(String numero) {
        return compteRepository.findByNumeroCompte(numero);
    }

    @Transactional
    public CompteFerme fermeCompte(String numeroCompte,String raison)
    {
        Compte compte = getCompteByNumero(numeroCompte);
        if(compte.getSolde()<0)
        {
            System.out.println("désole vous ne pouvez pas ferme le compte car votre Solde est inssufisant !!");
            return null;
        }
        else{
            compteRepository.fermeCompte(numeroCompte);
            cartRepository.deleteAllCartByNumeroCompte(numeroCompte);
            CompteFerme compteFerme = new CompteFerme();
            compteFerme.setCompte(compte);
            compteFerme.setDateFermeture(LocalDate.now());
            compteFerme.setRaison(raison);
            return compteFermeRepository.save(compteFerme);
        }
    }

    public String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = generateRandomAccountNumber();
        } while (compteRepository.existsByNumeroCompte(accountNumber));
        return accountNumber;
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder(ACCOUNT_NUMBER_LENGTH);
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }
    public Integer getSoldeByNumeroCart(String numeroCart)
    {
        return compteRepository.getSoldeByNumeroCart(numeroCart);
    }
    public Compte getCompteByNumeroCart(String numeroCart)
    {
        return getCompteByNumero(compteRepository.getnumeroCompteByNumeroCart(numeroCart));
    }
    public void miseAjourSolde(Compte compte)
    {
        compteRepository.save(compte);
    }
}
