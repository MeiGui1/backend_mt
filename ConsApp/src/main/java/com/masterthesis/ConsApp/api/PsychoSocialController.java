package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PsychoSocialAfter;
import com.masterthesis.ConsApp.model.PsychoSocialBefore;
import com.masterthesis.ConsApp.service.PatientService;
import com.masterthesis.ConsApp.service.PsychoSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1/psychosocial")
@RestController
public class PsychoSocialController {

    private final PsychoSocialService psychoSocialService;

    @Autowired
    public PsychoSocialController(PsychoSocialService psychoSocialService) {
        this.psychoSocialService = psychoSocialService;
    }

    @PostMapping(path = "/before")
    public void addPsychoSocialBefore(@RequestBody PsychoSocialBefore psychoSocialBefore){
        psychoSocialService.addPsychoSocialBefore(psychoSocialBefore);
    }

    @GetMapping(path = "/before")
    public List<PsychoSocialBefore> getAllPsychoSocialBefores(){
        return psychoSocialService.getAllPsychoSocialBefores();
    }

    @GetMapping(path = "/before/exists/{patient_id}")
    public boolean existsPsychoSocialBefore(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.existsPsychoSocialBefore(patient_id);
    }

    @GetMapping(path = "/before/{patient_id}")
    public PsychoSocialBefore getPsychoSocialBeforeById(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.getPsychoSocialBeforeById(patient_id);
    }

    @DeleteMapping(path = "/before/{patient_id}")
    public void deletePsychoSocialBeforeByID(@PathVariable("patient_id") int patient_id){
        psychoSocialService.deletePsychoSocialBefore(patient_id);
    }

    @PutMapping(path = "/before/{patient_id}")
    public void updatePsychoSocialBefore(@PathVariable("patient_id") int patient_id, @Valid @NotNull @RequestBody PsychoSocialBefore psychoSocialBeforeToUpdate){
        psychoSocialService.updatePsychoSocialBefore(patient_id, psychoSocialBeforeToUpdate);
    }




    @PostMapping(path = "/after")
    public void addPsychoSocialAfter(@RequestBody PsychoSocialAfter psychoSocialAfter){
        psychoSocialService.addPsychoSocialAfter(psychoSocialAfter);
    }

    @GetMapping(path = "/after")
    public List<PsychoSocialAfter> getAllPsychoSocialAfters(){
        return psychoSocialService.getAllPsychoSocialAfters();
    }

    @GetMapping(path = "/after/exists/{patient_id}")
    public boolean existsPsychoSocialAfter(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.existsPsychoSocialAfter(patient_id);
    }

    @GetMapping(path = "/after/{patient_id}")
    public PsychoSocialAfter getPsychoSocialAfterById(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.getPsychoSocialAfterById(patient_id);
    }

    @DeleteMapping(path = "/after/{patient_id}")
    public void deletePsychoSocialAfterByID(@PathVariable("patient_id") int patient_id){
        psychoSocialService.deletePsychoSocialAfter(patient_id);
    }

    @PutMapping(path = "/after/{patient_id}")
    public void updatePsychoSocialAfter(@PathVariable("patient_id") int patient_id, @Valid @NotNull @RequestBody PsychoSocialAfter psychoSocialAfterToUpdate){
        psychoSocialService.updatePsychoSocialAfter(patient_id, psychoSocialAfterToUpdate);
    }



    @PostMapping (path = "/reason")
    public void addImprovementReason(@RequestBody ImprovementReason improvementReason){
        psychoSocialService.addImprovementReason(improvementReason);
    }

    @GetMapping(path = "/reason")
    public List<ImprovementReason> getAllImprovementReasons(){
        return psychoSocialService.getAllImprovementReasons();
    }

    @GetMapping(path = "/reason/exists/{patient_id}")
    public boolean existsImprovementReason(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.existsImprovementReason(patient_id);
    }

    @GetMapping(path = "/reason/{patient_id}")
    public ImprovementReason getImprovementReasonById(@PathVariable("patient_id") int patient_id){
        return psychoSocialService.getImprovementReasonById(patient_id);
    }

    @DeleteMapping(path = "/reason/{patient_id}")
    public void deleteImprovementReasonByID(@PathVariable("patient_id") int patient_id){
        psychoSocialService.deleteImprovementReason(patient_id);
    }

    @PutMapping(path = "/reason/{patient_id}")
    public void updateImprovementReason(@PathVariable("patient_id") int patient_id, @Valid @NotNull @RequestBody ImprovementReason improvementReasonToUpdate){
        psychoSocialService.updateImprovementReason(patient_id, improvementReasonToUpdate);
    }
}
