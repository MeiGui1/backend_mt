package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PatientDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("drugRepository")
public class DrugDataAccessService implements DrugDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DrugDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //DrugType related

    @Override
    public int insertDrugType(int id, DrugType drugType) {
        return 0;
    }

    @Override
    public int insertDrugType(DrugType drugType) {
        final String sql = "INSERT INTO DrugType (name, description) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                drugType.getName(), drugType.getDescription()
        );
    }

    @Override
    public List<DrugType> selectAllDrugTypes() {
        final String sql = "SELECT id, name, description FROM DrugType ORDER BY name";
        List<DrugType> allDrugTypes = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description =  resultSet.getString("description");
            return new DrugType(id, name, description);
        });
        return allDrugTypes;
    }

    @Override
    public DrugType selectDrugTypeById(int id) {
        String sql = "SELECT * FROM DrugType WHERE id = ?";

        return (DrugType) jdbcTemplate.queryForObject(
                sql,
                new Object[] {id},
                new RowMapper<DrugType>() {
                    @Override
                    public DrugType mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        DrugType selectedDrugType = new DrugType(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"));
                        return selectedDrugType;
                    }
                });
    }

    @Override
    public int deleteDrugTypeById(int id) {
        String sql = "DELETE FROM DrugType WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateDrugTypeById(int id, DrugType drugType) {
        String sql = "UPDATE DrugType SET name = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, drugType.getName(), drugType.getDescription(), id);
    }



    //PatientDrug related

    @Override
    public int insertPatientDrug(int id, PatientDrug patientDrug) {
        return 0;
    }

    @Override
    public int insertPatientDrug(PatientDrug patientDrug) {
        final String sql = "INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                patientDrug.getPatient_id(), patientDrug.getDrugtype_id(), patientDrug.getAmount(), patientDrug.getDosis()
        );
    }

    @Override
    public List<PatientDrug> selectAllPatientDrugs() {
        final String sql = "SELECT * FROM PatientDrug ORDER BY patient_id";
        List<PatientDrug> allPatientDrugs = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int drugtype_id = resultSet.getInt("drugtype_id");
            String amount = resultSet.getString("amount");
            String dosis =  resultSet.getString("dosis");
            return new PatientDrug(patient_id, drugtype_id, amount, dosis);
        });
        return allPatientDrugs;
    }

    @Override
    public List<PatientDrug> selectAllDrugsOfPatient(int patient_id) {
        final String sql = "SELECT * FROM PatientDrug WHERE patient_id = "+ patient_id;
        List<PatientDrug> allDrugsOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            int drugtype_id = resultSet.getInt("drugtype_id");
            String amount = resultSet.getString("amount");
            String dosis =  resultSet.getString("dosis");
            return new PatientDrug(patient_id, drugtype_id, amount, dosis);
        });
        return allDrugsOfPatient;
    }

    @Override
    public PatientDrug selectPatientDrugByIds(int patient_id, int drugtype_id) {
        final String sql = "SELECT * FROM PatientDrug WHERE patient_id = ? AND drugtype_id = ?";
        return (PatientDrug) jdbcTemplate.queryForObject(
                sql,
                new Object[] {patient_id, drugtype_id},
                new RowMapper<PatientDrug>() {
                    @Override
                    public PatientDrug mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        PatientDrug selectedPatientDrug = new PatientDrug(
                                rs.getInt("patient_id"),
                                rs.getInt("drugtype_id"),
                                rs.getString("amount"),
                                rs.getString("dosis"));
                        return selectedPatientDrug;
                    }
                });
    }

    @Override
    public int deleteDrugOfPatient(int patient_id, int drugtype_id) {
        String sql = "DELETE FROM PatientDrug WHERE patient_id = ? AND drugtype_id = ?";
        Object[] args = new Object[] {patient_id, drugtype_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePatientDrugByIds(int patient_id, int drugtype_id, PatientDrug patientDrug) {
        String sql = "UPDATE PatientDrug SET amount = ?, dosis = ? WHERE patient_id = ? AND drugtype_id = ?";
        return jdbcTemplate.update(sql, patientDrug.getAmount(), patientDrug.getDosis(), patient_id, drugtype_id);
    }
}
