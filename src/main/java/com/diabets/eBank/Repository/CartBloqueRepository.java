package com.diabets.eBank.Repository;

import com.diabets.eBank.models.Carte;
import com.diabets.eBank.models.CarteBloque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartBloqueRepository extends JpaRepository<CarteBloque,Integer> {
}
