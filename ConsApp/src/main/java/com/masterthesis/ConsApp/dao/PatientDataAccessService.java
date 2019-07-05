package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("patientRepository")
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
        final String sql = "INSERT INTO Patient (shortname, gender) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patient.getShortname(), patient.getGender()
        );
    }

    @Override
    public List<Patient> selectAllPatients() {
        final String sql = "SELECT id, shortname, gender FROM Patient";
        List<Patient> allPatients = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String shortname = resultSet.getString("shortname");
            String gender =  resultSet.getString("gender");
            return new Patient(id, shortname, gender);
        });
        return allPatients;
    }

    @Override
    public Patient selectPatientById(int id) {
        String sql = "SELECT * FROM Patient WHERE id = ?";

        return (Patient) jdbcTemplate.queryForObject(
                sql,
                new Object[] {id},
                new RowMapper<Patient>() {
                    @Override
                    public Patient mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        Patient selectedPatient = new Patient(rs.getInt("id"),
                                rs.getString("shortname"),
                                rs.getString("gender"));
                        return selectedPatient;
                    }
                });
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
