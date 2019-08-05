package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.DiagnosisDao;
import com.masterthesis.ConsApp.model.DiagnosisType;
import com.masterthesis.ConsApp.model.PatientDiagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {

    private final DiagnosisDao diagnosisDao;

    @Autowired
    public DiagnosisService(@Qualifier("diagnosisRepository") DiagnosisDao diagnosisDao) {
        this.diagnosisDao = diagnosisDao;
    }


    public int addDiagnosisType(DiagnosisType diagnosisType) {
        return diagnosisDao.insertDiagnosisType(diagnosisType);
    }

    public List<DiagnosisType> getAllDiagnosisTypes() {
        return diagnosisDao.selectAllDiagnosisTypes();
    }

    public List<DiagnosisType> getDiagnosisTypesByClass(String type) {
        return diagnosisDao.selectDiagnosisTypesByClass(type);
    }

    public List<String> getAllDiagnosisTypeClasses() {
        return diagnosisDao.selectAllDiagnosisTypeClasses();
    }

    public DiagnosisType getDiagnosisTypeById(int id) {
        return diagnosisDao.selectDiagnosisTypeById(id);
    }

    public int deleteDiagnosisType(int id) {
        return diagnosisDao.deleteDiagnosisTypeById(id);
    }

    public int updateDiagnosisType(int id, DiagnosisType diagnosisType) {
        return diagnosisDao.updateDiagnosisTypeById(id, diagnosisType);
    }


    public int addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        return diagnosisDao.insertPatientDiagnosis(patientDiagnosis);
    }

    public List<PatientDiagnosis> getAllPatientDiagnoses() {
        return diagnosisDao.selectAllPatientDiagnoses();
    }

    public List<PatientDiagnosis> getAllDiagnosesOfPatient(int patient_id) {
        return diagnosisDao.selectAllDiagnosesOfPatient(patient_id);
    }

    public List<PatientDiagnosis> getDiagnosesOfPatientByClass(int patient_id, String type) {
        return diagnosisDao.selectDiagnosesOfPatientByClass(patient_id, type);
    }

    public PatientDiagnosis getPatientDiagnosisByIds(int patient_id, int diagnosistype_id) {
        return diagnosisDao.selectPatientDiagnosisByIds(patient_id, diagnosistype_id);
    }

    public int deletePatientDiagnosis(int patient_id, int diagnosistype_id) {
        return diagnosisDao.deleteDiagnosisOfPatient(patient_id, diagnosistype_id);
    }

    public int updatePatientDiagnosis(int patient_id, int diagnosistype_id, PatientDiagnosis patientDiagnosis) {
        return diagnosisDao.updatePatientDiagnosisByIds(patient_id, diagnosistype_id, patientDiagnosis);
    }

    public int getLastDiagnosisId() {
        return diagnosisDao.getLastDiagnosisId();
    }
}
