package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.DiagnosisType;
import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.PatientDiagnosis;
import com.masterthesis.ConsApp.model.PatientDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("diagnosisRepository")
public class DiagnosisDataAccessService implements DiagnosisDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiagnosisDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //DiagnosisType related


    @Override
    public int insertDiagnosisType(int id, DiagnosisType DiagnosisType) {
        return 0;
    }

    @Override
    public int insertDiagnosisType(DiagnosisType diagnosisType) {
        final String sql = "INSERT INTO DiagnosisType (name, type, description) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                diagnosisType.getName(), diagnosisType.getType(), diagnosisType.getDescription()
        );
    }

    @Override
    public List<DiagnosisType> selectAllDiagnosisTypes() {
        final String sql = "SELECT * FROM DiagnosisType ORDER BY name";
        List<DiagnosisType> allDiagnosisTypes = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            String description = resultSet.getString("description");
            return new DiagnosisType(id, name, type, description);
        });
        return allDiagnosisTypes;
    }

    @Override
    public List<DiagnosisType> selectDiagnosisTypesByClass(String type) {
        final String sql = "SELECT * FROM DiagnosisType WHERE type = '" + type + "'";
        List<DiagnosisType> allDiagnosesOfClass = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            return new DiagnosisType(id, name, type, description);
        });
        return allDiagnosesOfClass;
    }

    @Override
    public List<String> selectAllDiagnosisTypeClasses() {
        final String sql = "SELECT DISTINCT type FROM DiagnosisType ORDER BY type";
        List<String> allDiagnosisTypeClasses = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getString("type"));
        return allDiagnosisTypeClasses;
    }

    @Override
    public DiagnosisType selectDiagnosisTypeById(int id) {
        String sql = "SELECT * FROM DiagnosisType WHERE id = ?";
        return (DiagnosisType) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new RowMapper<DiagnosisType>() {
                    @Override
                    public DiagnosisType mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        DiagnosisType selectedDiagnosisType = new DiagnosisType(id,
                                rs.getString("name"),
                                rs.getString("type"),
                                rs.getString("description"));
                        return selectedDiagnosisType;
                    }
                });
    }

    @Override
    public int deleteDiagnosisTypeById(int id) {
        String sql = "DELETE FROM DiagnosisType WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateDiagnosisTypeById(int id, DiagnosisType diagnosisType) {
        String sql = "UPDATE DiagnosisType SET name = ?, type = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, diagnosisType.getName(), diagnosisType.getType(), diagnosisType.getDescription(), id);
    }


    //PatientDiagnosis related

    @Override
    public int insertPatientDiagnosis(int id, PatientDiagnosis patientDiagnosis) {
        return 0;
    }

    @Override
    public int insertPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        final String sql = "INSERT INTO PatientDiagnosis (patient_id, diagnosistype_id, comment) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                patientDiagnosis.getPatient_id(), patientDiagnosis.getDiagnosistype_id(), patientDiagnosis.getComment()
        );
    }

    @Override
    public List<PatientDiagnosis> selectAllPatientDiagnoses() {
        final String sql = "SELECT * FROM PatientDiagnosis ORDER BY patient_id";
        List<PatientDiagnosis> allPatientDiagnoses = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int diagnosistype_id = resultSet.getInt("diagnosistype_id");
            String comment = resultSet.getString("comment");
            return new PatientDiagnosis(patient_id, diagnosistype_id, comment);
        });
        return allPatientDiagnoses;
    }

    @Override
    public List<PatientDiagnosis> selectAllDiagnosesOfPatient(int patient_id) {
        final String sql = "SELECT * FROM PatientDiagnosis WHERE patient_id = " + patient_id;
        List<PatientDiagnosis> allDiagnosesOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            int diagnosistype_id = resultSet.getInt("diagnosistype_id");
            String comment = resultSet.getString("comment");
            return new PatientDiagnosis(patient_id, diagnosistype_id, comment);
        });
        return allDiagnosesOfPatient;
    }

    @Override
    public List<PatientDiagnosis> selectDiagnosesOfPatientByClass(int patient_id, String type) {
        final String sql = "SELECT patient_id, diagnosistype_id, type, comment FROM PatientDiagnosis " +
                "INNER JOIN DiagnosisType " +
                "ON PatientDiagnosis.diagnosistype_id =  DiagnosisType.id " +
                "WHERE PatientDiagnosis.patient_id = " + patient_id + " AND DiagnosisType.type = '"+ type + "'";
        List<PatientDiagnosis> selectedPatientDiagnoses = jdbcTemplate.query(sql, (resultSet, i) -> {
            int diagnosistype_id = resultSet.getInt("diagnosistype_id");
            String comment = resultSet.getString("comment");
            return new PatientDiagnosis(patient_id, diagnosistype_id, comment);
        });
        return selectedPatientDiagnoses;
    }

    @Override
    public PatientDiagnosis selectPatientDiagnosisByIds(int patient_id, int diagnosistype_id) {
        final String sql = "SELECT * FROM PatientDiagnosis WHERE patient_id = ? AND diagnosistype_id = ?";
        return (PatientDiagnosis) jdbcTemplate.queryForObject(
                sql,
                new Object[]{patient_id, diagnosistype_id},
                new RowMapper<PatientDiagnosis>() {
                    @Override
                    public PatientDiagnosis mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        PatientDiagnosis selectedPatientDiagnosis = new PatientDiagnosis(
                                patient_id,
                                diagnosistype_id,
                                rs.getString("comment"));
                        return selectedPatientDiagnosis;
                    }
                });
    }

    @Override
    public int deleteDiagnosisOfPatient(int patient_id, int diagnosistype_id) {
        String sql = "DELETE FROM PatientDiagnosis WHERE patient_id = ? AND diagnosistype_id = ?";
        Object[] args = new Object[]{patient_id, diagnosistype_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePatientDiagnosisByIds(int patient_id, int diagnosistype_id, PatientDiagnosis patientDiagnosis) {
        String sql = "UPDATE PatientDiagnosis SET comment = ? WHERE patient_id = ? AND diagnosistype_id = ?";
        return jdbcTemplate.update(sql, patientDiagnosis.getComment(), patient_id, diagnosistype_id);
    }

}
