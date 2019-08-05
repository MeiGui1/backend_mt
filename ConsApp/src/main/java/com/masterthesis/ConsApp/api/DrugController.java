package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PatientDrug;
import com.masterthesis.ConsApp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1")
@RestController
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @PostMapping(path = "/drugtype")
    public void addDrugType(@RequestBody DrugType drugType){
        drugService.addDrugType(drugType);
    }

    @GetMapping(path = "/drugtype")
    public List<DrugType> getAllDrugTypes(){
        return drugService.getAllDrugTypes();
    }

    @GetMapping(path = "/drugtype/{id}")
    public DrugType getDrugTypeById(@PathVariable("id") int id){
        return drugService.getDrugTypeById(id);
    }

    @DeleteMapping(path = "/drugtype/{id}")
    public void deleteDrugTypeById(@PathVariable("id") int id){
        drugService.deleteDrugType(id);
    }

    @PutMapping(path = "/drugtype/{id}")
    public void updateDrugType(@PathVariable("id") int id, @Valid @NotNull @RequestBody DrugType drugType){
        drugService.updateDrugType(id, drugType);
    }

    @GetMapping(path = "/drugtype_last_id")
    public int getLastPatientId(){
        return drugService.getLastDrugId();
    }


    
    @PostMapping(path = "/patientdrug")
    public void addPatientDrug(@RequestBody PatientDrug patientDrug){
        drugService.addPatientDrug(patientDrug);
    }

    @GetMapping(path = "/patientdrug")
    public List<PatientDrug> getAllPatientDrugs(){
        return drugService.getAllPatientDrugs();
    }

    @GetMapping(path = "/patientdrug/{id}")
    public List<PatientDrug> getAllDrugsOfPatient(@PathVariable("id") int id){
        return drugService.getAllDrugsOfPatient(id);
    }

    @GetMapping(path = "/patientdrug/{patient_id}/{drugtype_id}")
    public PatientDrug getPatientDrug(@PathVariable("patient_id") int patient_id, @PathVariable("drugtype_id") int drugtype_id){
        return drugService.getPatientDrugByIds(patient_id, drugtype_id);
    }

    @DeleteMapping(path = "/patientdrug/{patient_id}/{drugtype_id}")
    public void deleteDrugTypeById(@PathVariable("patient_id") int patient_id, @PathVariable("drugtype_id") int drugtype_id){
        drugService.deletePatientDrug(patient_id, drugtype_id);
    }

    @PutMapping(path = "/patientdrug/{patient_id}/{drugtype_id}")
    public void updateDrugType(@PathVariable("patient_id") int patient_id, @PathVariable("drugtype_id") int drugtype_id, @Valid @NotNull @RequestBody PatientDrug patientDrug){
        drugService.updatePatientDrug(patient_id, drugtype_id, patientDrug);
    }


}
