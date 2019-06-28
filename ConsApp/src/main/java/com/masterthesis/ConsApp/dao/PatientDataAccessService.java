package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sqlite")
public class PatientDataAccessService implements PatientDao{
    @Override
    public int insertPatient(UUID id, Patient patient) {
        return 0;
    }

    @Override
    public List<Patient> selectAllPatients() {
        return List.of(new Patient(UUID.randomUUID(), "FROM POSTGRES DB", "w"));
    }

    @Override
    public Optional<Patient> selectPatientById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePatientById(UUID id) {
        return 0;
    }

    @Override
    public int updatePatientById(UUID id, Patient patient) {
        return 0;
    }
}
