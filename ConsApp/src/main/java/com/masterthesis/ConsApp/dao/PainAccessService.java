package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.PainCurrent;
import com.masterthesis.ConsApp.model.PsychoSocialAfter;
import com.masterthesis.ConsApp.model.PainBeginning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("painRepository")
public class PainAccessService implements PainDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PainAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPainBeginning(PainBeginning painBeginning) {
        final String sql = "INSERT INTO PainBeginning (patient_id, intensity, location_teeth, location_face_left, location_face_right, " +
                "pain_pattern, dull, pulling, stinging, pulsating, burning, pinsneedles, tingling, numb) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                painBeginning.getPatient_id(),
                painBeginning.getIntensity(),
                painBeginning.getLocation_teeth(), painBeginning.getLocation_face_left(), painBeginning.getLocation_face_right(),
                painBeginning.getPain_pattern(),
                painBeginning.isDull(), painBeginning.isPulling(),
                painBeginning.isStinging(), painBeginning.isPulsating(),
                painBeginning.isBurning(), painBeginning.isPinsneedles(),
                painBeginning.isTingling(), painBeginning.isNumb()
        );
    }

    @Override
    public List<PainBeginning> selectAllPainBeginnings() {
        final String sql = "SELECT * FROM PainBeginning ORDER BY patient_id";
        List<PainBeginning> allPainBeginning = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int intensity = resultSet.getInt("intensity");
            byte[] location_teeth = resultSet.getBytes("location_teeth");
            byte[] location_face_left = resultSet.getBytes("location_face_left");
            byte[] location_face_right = resultSet.getBytes("location_face_right");
            String pain_pattern = resultSet.getString("pain_pattern");
            boolean dull = resultSet.getBoolean("dull");
            boolean pulling = resultSet.getBoolean("pulling");
            boolean stinging = resultSet.getBoolean("stinging");
            boolean pulsating = resultSet.getBoolean("pulsating");
            boolean burning = resultSet.getBoolean("burning");
            boolean pinsneedles = resultSet.getBoolean("pinsneedles");
            boolean tingling = resultSet.getBoolean("tingling");
            boolean numb = resultSet.getBoolean("numb");
            return new PainBeginning(patient_id, intensity, location_teeth, location_face_left, location_face_right, pain_pattern, dull, pulling, stinging, pulsating, burning, pinsneedles, tingling, numb);
        });
        return allPainBeginning;
    }

    @Override
    public PainBeginning selectPainBeginningByPatientId(int patient_id) {
        String sql = "SELECT * FROM PainBeginning WHERE patient_id = ?";

        try {
            PainBeginning selectedPainBeginning = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{patient_id},
                    new RowMapper<PainBeginning>() {
                        @Override
                        public PainBeginning mapRow(ResultSet rs, int rowNumber) throws SQLException {
                            PainBeginning selectedPainBeginning = new PainBeginning(
                                    patient_id,
                                    rs.getInt("intensity"),
                                    rs.getBytes("location_teeth"),
                                    rs.getBytes("location_face_left"),
                                    rs.getBytes("location_face_right"),
                                    rs.getString("pain_pattern"),
                                    rs.getBoolean("dull"),
                                    rs.getBoolean("pulling"),
                                    rs.getBoolean("stinging"),
                                    rs.getBoolean("pulsating"),
                                    rs.getBoolean("burning"),
                                    rs.getBoolean("pinsneedles"),
                                    rs.getBoolean("tingling"),
                                    rs.getBoolean("numb")
                            );
                            return selectedPainBeginning;
                        }
                    });
            return selectedPainBeginning;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deletePainBeginningByPatientId(int patient_id) {
        String sql = "DELETE FROM PainBeginning WHERE patient_id = ?";
        Object[] args = new Object[]{patient_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePainBeginningByPatientId(int patient_id, PainBeginning painBeginning) {
        String sql = "UPDATE PainBeginning SET intensity = ?, location_teeth = ?, location_face_left = ?, location_face_right = ?, pain_pattern = ?, " +
                "dull = ?, pulling= ?, stinging = ?, pulsating = ?, burning = ?, pinsneedles = ?, tingling = ?, numb = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                painBeginning.getIntensity(),
                painBeginning.getLocation_teeth(), painBeginning.getLocation_face_left(), painBeginning.getLocation_face_right(),
                painBeginning.getPain_pattern(),
                painBeginning.isDull(), painBeginning.isPulling(),
                painBeginning.isStinging(), painBeginning.isPulsating(),
                painBeginning.isBurning(), painBeginning.isPinsneedles(),
                painBeginning.isTingling(), painBeginning.isNumb(),
                patient_id);
    }

    @Override
    public boolean existsPainBeginning(int patient_id) {
        String sql = "SELECT COUNT(*) FROM PainBeginning WHERE patient_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, patient_id);
        return count != null && count > 0;
    }



    @Override
    public int insertPainCurrent(PainCurrent painCurrent) {
        final String sql = "INSERT INTO PainCurrent (patient_id, intensity, location_teeth, location_face_left, location_face_right, " +
                "pain_pattern, dull, pulling, stinging, pulsating, burning, pinsneedles, tingling, numb) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                painCurrent.getPatient_id(),
                painCurrent.getIntensity(),
                painCurrent.getLocation_teeth(), painCurrent.getLocation_face_left(), painCurrent.getLocation_face_right(),
                painCurrent.getPain_pattern(),
                painCurrent.isDull(), painCurrent.isPulling(),
                painCurrent.isStinging(), painCurrent.isPulsating(),
                painCurrent.isBurning(), painCurrent.isPinsneedles(),
                painCurrent.isTingling(), painCurrent.isNumb()
        );
    }

    @Override
    public List<PainCurrent> selectAllPainCurrents() {
        final String sql = "SELECT * FROM PainCurrent ORDER BY patient_id";
        List<PainCurrent> allPainCurrent = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int intensity = resultSet.getInt("intensity");
            byte[] location_teeth = resultSet.getBytes("location_teeth");
            byte[] location_face_left = resultSet.getBytes("location_face_left");
            byte[] location_face_right = resultSet.getBytes("location_face_right");
            String pain_pattern = resultSet.getString("pain_pattern");
            boolean dull = resultSet.getBoolean("dull");
            boolean pulling = resultSet.getBoolean("pulling");
            boolean stinging = resultSet.getBoolean("stinging");
            boolean pulsating = resultSet.getBoolean("pulsating");
            boolean burning = resultSet.getBoolean("burning");
            boolean pinsneedles = resultSet.getBoolean("pinsneedles");
            boolean tingling = resultSet.getBoolean("tingling");
            boolean numb = resultSet.getBoolean("numb");
            return new PainCurrent(patient_id, intensity, location_teeth, location_face_left, location_face_right, pain_pattern, dull, pulling, stinging, pulsating, burning, pinsneedles, tingling, numb);
        });
        return allPainCurrent;
    }

    @Override
    public PainCurrent selectPainCurrentByPatientId(int patient_id) {
        String sql = "SELECT * FROM PainCurrent WHERE patient_id = ?";

        try {
            PainCurrent selectedPainCurrent = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{patient_id},
                    new RowMapper<PainCurrent>() {
                        @Override
                        public PainCurrent mapRow(ResultSet rs, int rowNumber) throws SQLException {
                            PainCurrent selectedPainCurrent = new PainCurrent(
                                    patient_id,
                                    rs.getInt("intensity"),
                                    rs.getBytes("location_teeth"),
                                    rs.getBytes("location_face_left"),
                                    rs.getBytes("location_face_right"),
                                    rs.getString("pain_pattern"),
                                    rs.getBoolean("dull"),
                                    rs.getBoolean("pulling"),
                                    rs.getBoolean("stinging"),
                                    rs.getBoolean("pulsating"),
                                    rs.getBoolean("burning"),
                                    rs.getBoolean("pinsneedles"),
                                    rs.getBoolean("tingling"),
                                    rs.getBoolean("numb")
                            );
                            return selectedPainCurrent;
                        }
                    });
            return selectedPainCurrent;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deletePainCurrentByPatientId(int patient_id) {
        String sql = "DELETE FROM PainCurrent WHERE patient_id = ?";
        Object[] args = new Object[]{patient_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePainCurrentByPatientId(int patient_id, PainCurrent painCurrent) {
        String sql = "UPDATE PainCurrent SET intensity = ?, location_teeth = ?, location_face_left = ?, location_face_right = ?, pain_pattern = ?, " +
                "dull = ?, pulling= ?, stinging = ?, pulsating = ?, burning = ?, pinsneedles = ?, tingling = ?, numb = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                painCurrent.getIntensity(),
                painCurrent.getLocation_teeth(), painCurrent.getLocation_face_left(), painCurrent.getLocation_face_right(),
                painCurrent.getPain_pattern(),
                painCurrent.isDull(), painCurrent.isPulling(),
                painCurrent.isStinging(), painCurrent.isPulsating(),
                painCurrent.isBurning(), painCurrent.isPinsneedles(),
                painCurrent.isTingling(), painCurrent.isNumb(),
                patient_id);
    }

    @Override
    public boolean existsPainCurrent(int patient_id) {
        String sql = "SELECT COUNT(*) FROM PainCurrent WHERE patient_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, patient_id);
        return count != null && count > 0;
    }
}
