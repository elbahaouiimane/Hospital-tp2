package com.tp2.Hospital.service;

import com.tp2.Hospital.entities.Consultation;
import com.tp2.Hospital.entities.Medecin;
import com.tp2.Hospital.entities.Patient;
import com.tp2.Hospital.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRendezVous(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);


}
