package com.tp2.Hospital.repositories;

import com.tp2.Hospital.entities.Consultation;
import com.tp2.Hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
