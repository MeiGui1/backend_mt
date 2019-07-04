package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class PatientDataAccessService implements PatientDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPatient(int id, Patient patient) {
        return 0;
    }

    @Override
    public int insertPatient(Patient patient) {
        return 0;
    }

    @Override
    public List<Patient> selectAllPatients() {
        final String sql = "SELECT id, shortname, gender FROM patient";
        List<Patient> allPatients = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String shortname = resultSet.getString("shortname");
            String gender =  resultSet.getString("gender");
            return new Patient(id, shortname, gender);
        });
        return allPatients;
    }

    @Override
    public Optional<Patient> selectPatientById(int id) {
        return Optional.empty();
    }

    @Override
    public int deletePatientById(int id) {
        return 0;
    }

    @Override
    public int updatePatientById(int id, Patient patient) {
        return 0;
    }
}
