package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PatientDrug;

import java.util.List;
import java.util.Optional;

public interface DrugDao {

    /*DrugType table related functions*/

    int insertDrugType(int id, DrugType drugType);
    int insertDrugType(DrugType drugType);
    List<DrugType> selectAllDrugTypes();
    DrugType selectDrugTypeById(int id);
    int deleteDrugTypeById(int id);
    int updateDrugTypeById(int id, DrugType drugType);
    int selectLastDrugId();

    /*DrugPatient table related functions*/

    int insertPatientDrug(int id, PatientDrug patientDrug);
    int insertPatientDrug(PatientDrug patientDrug);
    List<PatientDrug> selectAllPatientDrugs();
    List<PatientDrug> selectAllDrugsOfPatient(int patient_id);
    PatientDrug selectPatientDrugByIds(int patient_id, int drugtype_id);
    int deleteDrugOfPatient(int patient_id, int drugtype_id);
    int updatePatientDrugByIds(int patient_id, int drugtype_id, PatientDrug patientDrug);

}
