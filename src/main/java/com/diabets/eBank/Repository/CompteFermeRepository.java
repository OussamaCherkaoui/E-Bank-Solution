package com.diabets.eBank.Repository;

import com.diabets.eBank.models.CompteFerme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteFermeRepository extends JpaRepository<CompteFerme,Integer>{

}
