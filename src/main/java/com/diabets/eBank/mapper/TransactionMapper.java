package com.diabets.eBank.mapper;

import com.diabets.eBank.dto.TransactionDTO;
import com.diabets.eBank.models.Transaction;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction transaction) {
        return TransactionDTO.builder()
                .idTransaction(transaction.getIdTransaction())
                .montant(transaction.getMontant())
                .dateTransaction(transaction.getDateTransaction())
                .typeTransaction(transaction.getTypeTransaction())
                .description(transaction.getDescription())
                .numeroCarte(transaction.getCarte().getNumeroCarte()) // Référence simple
                .numeroCompte(transaction.getCompte().getNumeroCompte()) // Référence simple
                .build();
    }

    public static Transaction toEntity(TransactionDTO transactionDTO) {
        Transaction transaction = Transaction.builder()
                .idTransaction(transactionDTO.getIdTransaction())
                .montant(transactionDTO.getMontant())
                .dateTransaction(transactionDTO.getDateTransaction())
                .typeTransaction(transactionDTO.getTypeTransaction())
                .description(transactionDTO.getDescription())
                .build();
        // Associer la carte et le compte doit être géré séparément dans le service
        return transaction;
    }
}
