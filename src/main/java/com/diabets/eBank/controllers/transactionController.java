package com.diabets.eBank.controllers;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.Transaction;
import com.diabets.eBank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/compte/cart/transaction")
@CrossOrigin(origins = "http://localhost:4200/")
public class transactionController{
    @Autowired
    TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
        Optional<Transaction> transactionSaved = transactionService.transfer(transaction);
        return new ResponseEntity<>(transactionSaved, HttpStatus.CREATED);
    }
}
