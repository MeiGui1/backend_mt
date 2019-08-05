package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.DiagnosisType;
import com.masterthesis.ConsApp.model.PatientDiagnosis;
import com.masterthesis.ConsApp.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1")
@RestController
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @PostMapping(path = "/diagnosistype")
    public void addDiagnosisType(@RequestBody DiagnosisType diagnosisType){
        diagnosisService.addDiagnosisType(diagnosisType);
    }

    @GetMapping(path = "/diagnosistype")
    public List<DiagnosisType> getAllDiagnosisTypes(){
        return diagnosisService.getAllDiagnosisTypes();
    }

    @GetMapping(path = "/diagnosistype/type={type}")
    public List<DiagnosisType> getDiagnosisTypesByClass(@PathVariable("type") String type){
        return diagnosisService.getDiagnosisTypesByClass(type);
    }

    @GetMapping(path = "/diagnosistype/type")
    public List<String> getAllDiagnosisTypeClasses(){
        return diagnosisService.getAllDiagnosisTypeClasses();
    }

    @GetMapping(path = "/diagnosistype/{id}")
    public DiagnosisType getDiagnosisTypeById(@PathVariable("id") int id){
        return diagnosisService.getDiagnosisTypeById(id);
    }

    @DeleteMapping(path = "/diagnosistype/{id}")
    public void deleteDiagnosisTypeById(@PathVariable("id") int id){
        diagnosisService.deleteDiagnosisType(id);
    }

    @PutMapping(path = "/diagnosistype/{id}")
    public void updateDiagnosisType(@PathVariable("id") int id, @Valid @NotNull @RequestBody DiagnosisType diagnosisType){
        diagnosisService.updateDiagnosisType(id, diagnosisType);
    }

    @GetMapping(path = "/diagnosistype_last_id")
    public int getLastNoteId(){
        return diagnosisService.getLastDiagnosisId();
    }



    @PostMapping(path = "/patientdiagnosis")
    public void addPatientDiagnosis(@RequestBody PatientDiagnosis patientDiagnosis){
        diagnosisService.addPatientDiagnosis(patientDiagnosis);
    }

    @GetMapping(path = "/patientdiagnosis")
    public List<PatientDiagnosis> getAllPatientDiagnoses(){
        return diagnosisService.getAllPatientDiagnoses();
    }

    @GetMapping(path = "/patientdiagnosis/{id}")
    public List<PatientDiagnosis> getAllDiagnosesOfPatient(@PathVariable("id") int id){
        return diagnosisService.getAllDiagnosesOfPatient(id);
    }

    @GetMapping(path = "/patientdiagnosis/{id}/type={type}")
    public List<PatientDiagnosis> getDiagnosesOfPatientByClass(@PathVariable("id") int id, @PathVariable("type") String type){
        return diagnosisService.getDiagnosesOfPatientByClass(id, type);
    }

    @GetMapping(path = "/patientdiagnosis/{patient_id}/{diagnosistype_id}")
    public PatientDiagnosis getPatientDiagnosis(@PathVariable("patient_id") int patient_id, @PathVariable("diagnosistype_id") int diagnosistype_id){
        return diagnosisService.getPatientDiagnosisByIds(patient_id, diagnosistype_id);
    }

    @DeleteMapping(path = "/patientdiagnosis/{patient_id}/{diagnosistype_id}")
    public void deleteDiagnosisTypeById(@PathVariable("patient_id") int patient_id, @PathVariable("diagnosistype_id") int diagnosistype_id){
        diagnosisService.deletePatientDiagnosis(patient_id, diagnosistype_id);
    }

    @PutMapping(path = "/patientdiagnosis/{patient_id}/{diagnosistype_id}")
    public void updateDiagnosisType(@PathVariable("patient_id") int patient_id, @PathVariable("diagnosistype_id") int diagnosistype_id, @Valid @NotNull @RequestBody PatientDiagnosis patientDiagnosis){
        diagnosisService.updatePatientDiagnosis(patient_id, diagnosistype_id, patientDiagnosis);
    }
}
