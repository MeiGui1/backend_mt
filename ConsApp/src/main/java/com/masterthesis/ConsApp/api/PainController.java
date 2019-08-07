package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.PainBeginning;
import com.masterthesis.ConsApp.model.PainCurrent;
import com.masterthesis.ConsApp.service.PainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1/pain")
@RestController
public class PainController {

    private final PainService painService;

    @Autowired
    public PainController(PainService painService) {
        this.painService = painService;
    }

    @PostMapping(path = "/beginning")
    public void addPainBeginning(@RequestBody PainBeginning painBeginning){
        painService.addPainBeginning(painBeginning);
    }

    @GetMapping(path = "/beginning")
    public List<PainBeginning> getAllPainBeginnings(){
        return painService.getAllPainBeginnings();
    }

    @GetMapping(path = "/beginning/exists/{patient_id}")
    public boolean existsPainBeginning(@PathVariable("patient_id") int patient_id){
        return painService.existsPainBeginning(patient_id);
    }

    @GetMapping(path = "/beginning/{patient_id}")
    public PainBeginning getPainBeginningById(@PathVariable("patient_id") int patient_id){
        return painService.getPainBeginningById(patient_id);
    }

    @DeleteMapping(path = "/beginning/{patient_id}")
    public void deletePainBeginningByID(@PathVariable("patient_id") int patient_id){
        painService.deletePainBeginning(patient_id);
    }

    @PutMapping(path = "/beginning/{patient_id}")
    public void updatePainBeginning(@PathVariable("patient_id") int patient_id, @RequestBody PainBeginning painBeginningToUpdate){
        painService.updatePainBeginning(patient_id, painBeginningToUpdate);
    }



    @PostMapping(path = "/current")
    public void addPainCurrent(@RequestBody PainCurrent painCurrent){
        painService.addPainCurrent(painCurrent);
    }

    @GetMapping(path = "/current")
    public List<PainCurrent> getAllPainCurrents(){
        return painService.getAllPainCurrents();
    }

    @GetMapping(path = "/current/exists/{patient_id}")
    public boolean existsPainCurrent(@PathVariable("patient_id") int patient_id){
        return painService.existsPainCurrent(patient_id);
    }

    @GetMapping(path = "/current/{patient_id}")
    public PainCurrent getPainCurrentById(@PathVariable("patient_id") int patient_id){
        return painService.getPainCurrentById(patient_id);
    }

    @DeleteMapping(path = "/current/{patient_id}")
    public void deletePainCurrentByID(@PathVariable("patient_id") int patient_id){
        painService.deletePainCurrent(patient_id);
    }

    @PutMapping(path = "/current/{patient_id}")
    public void updatePainCurrent(@PathVariable("patient_id") int patient_id, @RequestBody PainCurrent painCurrentToUpdate){
        painService.updatePainCurrent(patient_id, painCurrentToUpdate);
    }
}
