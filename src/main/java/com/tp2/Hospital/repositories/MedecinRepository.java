package com.tp2.Hospital.repositories;

import com.tp2.Hospital.entities.Medecin;
import com.tp2.Hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
