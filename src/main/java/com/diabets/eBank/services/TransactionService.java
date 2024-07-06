package com.diabets.eBank.services;

import com.diabets.eBank.Repository.TransactionRepository;
import com.diabets.eBank.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction transfer(Transaction transaction)
    {
        Double solde = transaction.getCarte().getCompte().getSolde();
        Integer montant = transaction.getMontant();
        Boolean ifFermee=transaction.getCarte().getCompte().getEstFerme();
        if(ifFermee)
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
            return transactionRepository.save(transaction);
        }
    }
}
