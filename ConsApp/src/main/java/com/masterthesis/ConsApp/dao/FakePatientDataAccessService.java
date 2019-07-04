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
    public int insertPatient(int id, Patient patient) {
        DB.add(new Patient(id, patient.getShortname(), patient.getGender()));
        return 1;
    }

    @Override
    public int insertPatient(Patient patient) {
        DB.add(new Patient(100,patient.getShortname(), patient.getGender()));
        return 1;
    }

    @Override
    public List<Patient> selectAllPatients() {
        return DB;
    }

    @Override
    public Optional<Patient> selectPatientById(int id) {
        return DB.stream()
                .filter(patient -> patient.getId()==id)
                .findFirst();
    }

    @Override
    public int deletePatientById(int id) {
        Optional<Patient> personMaybe = selectPatientById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePatientById(int id, Patient newPatient) {
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
