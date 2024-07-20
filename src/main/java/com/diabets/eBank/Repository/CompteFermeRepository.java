package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Compte;
import com.diabets.eBank.models.CompteFerme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteFermeRepository extends JpaRepository<CompteFerme,Integer>{

    Optional<CompteFerme> findByCompte(Compte compte);
}
