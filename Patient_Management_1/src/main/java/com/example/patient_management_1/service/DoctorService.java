package com.example.patient_management_1.service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor getDoctor(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }

}
