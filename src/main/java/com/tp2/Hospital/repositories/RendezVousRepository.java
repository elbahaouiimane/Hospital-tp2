package com.tp2.Hospital.repositories;

import com.tp2.Hospital.entities.Patient;
import com.tp2.Hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

/*public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {

}*/
public interface RendezVousRepository extends JpaRepository<RendezVous,String> {


}
