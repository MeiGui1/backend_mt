package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.DiagnosisType;
import com.masterthesis.ConsApp.model.PatientDiagnosis;

import java.util.List;

public interface DiagnosisDao {

    /*DiagnosisType table related functions*/

    int insertDiagnosisType(int id, DiagnosisType DiagnosisType);
    int insertDiagnosisType(DiagnosisType DiagnosisType);
    List<DiagnosisType> selectAllDiagnosisTypes();
    List<DiagnosisType> selectDiagnosisTypesByClass(String type);
    List<String> selectAllDiagnosisTypeClasses();
    DiagnosisType selectDiagnosisTypeById(int id);
    int deleteDiagnosisTypeById(int id);
    int updateDiagnosisTypeById(int id, DiagnosisType DiagnosisType);


    /*DiagnosisPatient table related functions*/

    int insertPatientDiagnosis(int id, PatientDiagnosis patientDiagnosis);
    int insertPatientDiagnosis(PatientDiagnosis patientDiagnosis);
    List<PatientDiagnosis> selectAllPatientDiagnoses();
    List<PatientDiagnosis> selectAllDiagnosesOfPatient(int patient_id);
    List<PatientDiagnosis> selectDiagnosesOfPatientByClass(int patient_id, String type);
    PatientDiagnosis selectPatientDiagnosisByIds(int patient_id, int DiagnosisType_id);
    int deleteDiagnosisOfPatient(int patient_id, int DiagnosisType_id);
    int updatePatientDiagnosisByIds(int patient_id, int DiagnosisType_id, PatientDiagnosis patientDiagnosis);

}
