package com.tp2.Hospital;

import com.tp2.Hospital.entities.*;
import com.tp2.Hospital.repositories.ConsultationRepository;
import com.tp2.Hospital.repositories.MedecinRepository;
import com.tp2.Hospital.repositories.PatientRepository;
import com.tp2.Hospital.repositories.RendezVousRepository;
import com.tp2.Hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

	public static void main(String[] args) {

		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start( IHospitalService iHospitalService,
							 PatientRepository patientRepository,
							 RendezVousRepository rendezVousRepository,
							 ConsultationRepository consultationRepository,
							 MedecinRepository medecinRepository)

			/*PatientRepository patientRepository,
			MedecinRepository medecinRepository,
			RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository)*/
	     {
		return args -> {
			Stream.of("mehdi","marouane","malik")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateDeNaissance(new Date());
						patient.setMalade(false);
						/*patientRepository.save(patient);*/
						iHospitalService.savePatient(patient);
					});
			Stream.of("salim","malak","nawal")
					.forEach(name->{
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						/*medecinRepository.save(medecin);*/
						iHospitalService.saveMedecin(medecin);
					});
			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("mehdi");

			Medecin medecin = medecinRepository.findByNom("salim");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			/*RendezVous saveDRDV = rendezVousRepository.save(rendezVous);*/
			RendezVous saveDRDV = iHospitalService.saveRendezVous(rendezVous);
			System.out.println(saveDRDV.getId());
			/*iHospitalService.saveRendezVous(rendezVous);*/

			/*RendezVous rendezVous1= rendezVousRepository.findById(1L).orElse(null);*/
			RendezVous rendezVous1= rendezVousRepository.findAll().get(0);


			Consultation consultation= new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapport("Rapport de la consultation");
			consultation.setRendezVous(rendezVous1);
			consultationRepository.save(consultation);
			/*iHospitalService.saveConsultation(consultation);*/







		};
	}










}
