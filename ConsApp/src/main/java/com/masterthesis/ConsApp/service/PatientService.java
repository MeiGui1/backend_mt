package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.PatientDao;
import com.masterthesis.ConsApp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientService(@Qualifier("patientRepository") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public int addPatient(Patient patient){
        return patientDao.insertPatient(patient);
    }

    public List<Patient> getAllPatients(){
        return patientDao.selectAllPatients();
    }

    public Patient getPatientById(int id){
        return patientDao.selectPatientById(id);
    }

    public int deletePatient(int id){
        return patientDao.deletePatientById(id);
    }

    public int updatePatient(int id, Patient newPatient){
        return patientDao.updatePatientById(id, newPatient);
    }

    public int getLastNoteId() {
        return patientDao.selectLastPatientId();
    }
}
