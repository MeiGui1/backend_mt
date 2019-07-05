package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.DrugDao;
import com.masterthesis.ConsApp.dao.PatientDao;
import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PatientDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {

    private final DrugDao drugDao;

    @Autowired
    public DrugService(@Qualifier("drugRepository") DrugDao drugDao) {
        this.drugDao = drugDao;
    }


    public int addDrugType(DrugType drugType){
        return drugDao.insertDrugType(drugType);
    }

    public List<DrugType> getAllDrugTypes(){
        return drugDao.selectAllDrugTypes();
    }

    public Optional<DrugType> getDrugTypeById(int id){
        return drugDao.selectDrugTypeById(id);
    }

    public int deleteDrugType(int id){
        return drugDao.deleteDrugTypeById(id);
    }

    public int updateDrugType(int id, DrugType drugType){
        return drugDao.updateDrugTypeById(id, drugType);
    }



    public int addPatientDrug(PatientDrug patientDrug){
        return drugDao.insertPatientDrug(patientDrug);
    }

    public List<PatientDrug> getAllDrugsOfPatient(int patient_id){
        return drugDao.selectAllDrugsOfPatient(patient_id);
    }

    public Optional<PatientDrug> getPatientDrugByIds(int patient_id, int drugtype_id){
        return drugDao.selectPatientDrugByIds(patient_id, drugtype_id);
    }

    public int deletePatientDrug(int patient_id, int drugtype_id){
        return drugDao.deleteDrugOfPatient(patient_id, drugtype_id);
    }

    public int updatePatientDrug(int patient_id, int drugtype_id, PatientDrug patientDrug){
        return drugDao.updatePatientDrugByIds(patient_id, drugtype_id, patientDrug);
    }

}
