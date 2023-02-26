package com.oraiche.patientmvc;

import com.oraiche.patientmvc.entities.Patient;
import com.oraiche.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
     @Bean   //Execusion automatique au démarage
    CommandLineRunner commandLineRunner(PatientRepository patientRepository)
    {

        return args->{
         patientRepository.save(
                 new Patient(null,"Rachid",new Date(),false,5));
            patientRepository.save(
                    new Patient(null,"Hassan",new Date(),true,10));
            patientRepository.save(
                    new Patient(null,"Yassin",new Date(),false,51));
            patientRepository.save(
                    new Patient(null,"Imane",new Date(),true,10));

            patientRepository.findAll().forEach(p-> {
                System.out.println(p.getName());
            });

        };
    }

}
