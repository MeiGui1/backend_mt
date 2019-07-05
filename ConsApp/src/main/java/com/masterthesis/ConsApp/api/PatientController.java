package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.service.DrugService;
import com.masterthesis.ConsApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

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
    public Patient getPatientById(@PathVariable("id") int id){
        return personService.getPatientById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatientByID(@PathVariable("id") int id){
        personService.deletePatient(id);
    }

    @PutMapping(path = "{id}")
    public void updatePatient(@PathVariable("id") int id, @Valid @NotNull @RequestBody Patient patientToUpdate){
        personService.updatePatient(id, patientToUpdate);
    }
}
