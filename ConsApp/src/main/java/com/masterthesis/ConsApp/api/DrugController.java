package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1/drug")
@RestController
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @PostMapping
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

    @DeleteMapping(path = "{id}")
    public void deleteDrugTypeById(@PathVariable("id") int id){
        drugService.deleteDrugType(id);
    }

    @PutMapping(path = "{id}")
    public void updateDrugType(@PathVariable("id") int id, @Valid @NotNull @RequestBody DrugType drugType){
        drugService.updateDrugType(id, drugType);
    }
}
