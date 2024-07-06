package com.diabets.eBank.services;

import com.diabets.eBank.Repository.TransactionRepository;
import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CompteService compteService;

    public Optional<Transaction> transfer(Transaction transaction)
    {
        String numeroCarte = transaction.getCarte().getNumeroCarte();
        String numeroCompte = transaction.getCompte().getNumeroCompte();
        Compte compteRecept= compteService.getCompteByNumero(numeroCompte);
        Compte compteEmet = compteService.getCompteByNumeroCart(numeroCarte);
        Integer montant = transaction.getMontant();
        Integer solde = compteService.getSoldeByNumeroCart(numeroCarte);
        Boolean isFermee=compteEmet.getEstFerme();
        transaction.setDateTransaction(LocalDateTime.now());
        if (compteRecept==null){
            System.out.println("compte de beneficiaire non trouvé !!");
            return null;
        }
        else if(isFermee)
        {
            System.out.println("Transaction refus !! Votre compte est ferme");
            return null;
        }
        else if(montant>solde)
        {
            System.out.println("Transaction refus !! Votre solde est inssufisant");
            return null;
        }
        else{
            compteRecept.setSolde(montant+compteRecept.getSolde());
            compteService.miseAjourSolde(compteRecept);
            compteEmet.setSolde(compteEmet.getSolde()-montant);
            compteService.miseAjourSolde(compteEmet);
            return Optional.of(transactionRepository.save(transaction));
        }
    }
}
