package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;
import com.example.patient_management_1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

//    @Autowired
//    private PatientRepository patientRepository;
    @Autowired
    PatientService patientService;
    @GetMapping("/{id}")
    public Patient getPatients(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/")
    public Patient createPatient(@RequestBody Patient patient) {
      //  return patientRepository.save(patient);
        return patientService.createPatient(patient);
    }

    @PutMapping("/")
    public Patient updatePatient(@RequestBody Patient patient) {
        //return patientRepository.save(patient);
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
       // patientRepository.deleteById(id);
        patientService.deletePatient(id);
    }
}

