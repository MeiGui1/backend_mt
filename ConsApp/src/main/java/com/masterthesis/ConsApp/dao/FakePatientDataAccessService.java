package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePatientDataAccessService implements PatientDao {

    private static List<Patient> DB = new ArrayList<>();

    @Override
    public int insertPatient(UUID id, Patient patient) {
        DB.add(new Patient(id, patient.getShortname(), patient.getGender()));
        return 1;
    }

    @Override
    public List<Patient> selectAllPatients() {
        return DB;
    }

    @Override
    public Optional<Patient> selectPatientById(UUID id) {
        return DB.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePatientById(UUID id) {
        Optional<Patient> personMaybe = selectPatientById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePatientById(UUID id, Patient newPatient) {
        return selectPatientById(id)
                .map(patient -> {
                    int indexOfPersonToUpdate = DB.indexOf(patient);
                    if(indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Patient(id,newPatient.getShortname(), newPatient.getGender()));
                        return 1;
                    }else{
                        return 0;
                    }

                })
                .orElse(0);
    }
}
