package com.diabets.eBank.services;

import com.diabets.eBank.Repository.BeneficiaireRepository;
import com.diabets.eBank.models.Beneficiaire;
import com.diabets.eBank.models.Compte;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BeneficiaireService {
    @Autowired
    BeneficiaireRepository beneficiaireRepository;

    public Beneficiaire ajouterBeneficiaire(Beneficiaire beneficiaire){
        return beneficiaireRepository.save(beneficiaire);
    }
    @Transactional
    public Beneficiaire deleteBeneficiaireByCompteAndNumeroCompteBeneficiaire(Compte compteProprietaire, String numeroCompteBeneficiaire)
    {
        Beneficiaire beneficiaire = beneficiaireRepository.findBeneficiaireByCompteAndCompteBeneficiaire(compteProprietaire.getNumeroCompte(),numeroCompteBeneficiaire);
        if (beneficiaire != null) {
            beneficiaireRepository.deleteBeneficiaire(compteProprietaire.getNumeroCompte(), numeroCompteBeneficiaire);
            return beneficiaire;
        }
        return null;

    }
}
