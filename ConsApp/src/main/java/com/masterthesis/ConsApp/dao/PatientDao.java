package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientDao {
    int insertPatient(int id, Patient patient);

    int insertPatient(Patient patient);

    List<Patient> selectAllPatients();

    Optional<Patient> selectPatientById(int id);

    int deletePatientById(int id);

    int updatePatientById(int id, Patient patient);

}
