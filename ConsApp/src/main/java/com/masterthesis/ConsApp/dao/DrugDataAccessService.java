package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.DrugType;
import com.masterthesis.ConsApp.model.Patient;
import com.masterthesis.ConsApp.model.PatientDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("drugRepository")
public class DrugDataAccessService implements DrugDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DrugDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertDrugType(int id, DrugType drugType) {
        return 0;
    }

    @Override
    public int insertDrugType(DrugType drugType) {
        return 0;
    }

    @Override
    public List<DrugType> selectAllDrugTypes() {
        final String sql = "SELECT id, name, description FROM DrugType";
        List<DrugType> allDrugTypes = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description =  resultSet.getString("description");
            return new DrugType(id, name, description);
        });
        return allDrugTypes;
    }

    @Override
    public Optional<DrugType> selectDrugTypeById(int id) {
        return Optional.empty();
    }

    @Override
    public int deleteDrugTypeById(int id) {
        return 0;
    }

    @Override
    public int updateDrugTypeById(int id, DrugType drugType) {
        return 0;
    }

    @Override
    public int insertPatientDrug(int id, PatientDrug patientDrug) {
        return 0;
    }

    @Override
    public int insertPatientDrug(PatientDrug patientDrug) {
        return 0;
    }

    @Override
    public List<PatientDrug> selectAllDrugsOfPatient(int patient_id) {
        return null;
    }

    @Override
    public Optional<PatientDrug> selectPatientDrugByIds(int patient_id, int drugtype_id) {
        return Optional.empty();
    }

    @Override
    public int deleteDrugOfPatient(int patient_id, int drugtype_id) {
        return 0;
    }

    @Override
    public int updatePatientDrugByIds(int patient_id, int drugtype_id, PatientDrug patientDrug) {
        return 0;
    }
}
