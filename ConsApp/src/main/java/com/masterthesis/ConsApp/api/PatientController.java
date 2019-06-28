package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/patient")
@RestController
public class PatientController {

    private final PatientService personService;

    @Autowired
    public PatientController(PatientService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPatient(@RequestBody Patient patient){
        personService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return personService.getAllPatients();
    }

    @GetMapping(path = "{id}")
    public Patient getPatientById(@PathVariable("id") UUID id){
        return personService.getPatientById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatientByID(@PathVariable("id") UUID id){
        personService.deletePatient(id);
    }

    @PutMapping(path = "{id}")
    public void updatePatient(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Patient patientToUpdate){
        personService.updatePatient(id, patientToUpdate);
    }
}
