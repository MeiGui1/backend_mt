package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.PsychoSocialAfter;
import com.masterthesis.ConsApp.model.PsychoSocialBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("psychosocialRepository")
public class PsychoSocialAccessService implements PsychoSocialDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PsychoSocialAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPsychoSocialBefore(PsychoSocialBefore psBefore) {
        final String sql = "INSERT INTO PsychoSocialBefore (patient_id, pain_xpos, pain_ypos, familiy_xpos, familiy_ypos, work_xpos, work_ypos, finance_xpos, finance_ypos, event_xpos, event_ypos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                psBefore.getPatient_id(),
                psBefore.getPain_xpos(), psBefore.getPain_ypos(),
                psBefore.getFamily_xpos(), psBefore.getFamily_ypos(),
                psBefore.getWork_xpos(), psBefore.getWork_ypos(),
                psBefore.getFinance_xpos(), psBefore.getFinance_ypos(),
                psBefore.getEvent_xpos(), psBefore.getEvent_ypos()
        );
    }

    @Override
    public List<PsychoSocialBefore> selectAllPsychoSocialBefores() {
        final String sql = "SELECT * FROM PsychoSocialBefore ORDER BY patient_id";
        List<PsychoSocialBefore> allPsBefore = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int pain_xpos = resultSet.getInt("pain_xpos");
            int pain_ypos = resultSet.getInt("pain_ypos");
            int familiy_xpos = resultSet.getInt("familiy_xpos");
            int familiy_ypos = resultSet.getInt("familiy_ypos");
            int work_xpos = resultSet.getInt("work_xpos");
            int work_ypos = resultSet.getInt("work_ypos");
            int finance_xpos = resultSet.getInt("finance_xpos");
            int finance_ypos = resultSet.getInt("finance_ypos");
            int event_xpos = resultSet.getInt("event_xpos");
            int event_ypos = resultSet.getInt("event_ypos");
            return new PsychoSocialBefore(patient_id, pain_xpos, pain_ypos, familiy_xpos, familiy_ypos, work_xpos, work_ypos, finance_xpos, finance_ypos, event_xpos, event_ypos);
        });
        return allPsBefore;
    }

    @Override
    public PsychoSocialBefore selectPsychoSocialBeforeByPatientId(int patient_id) {
        String sql = "SELECT * FROM PsychoSocialBefore WHERE patient_id = ?";

        return (PsychoSocialBefore) jdbcTemplate.queryForObject(
                sql,
                new Object[] {patient_id},
                new RowMapper<PsychoSocialBefore>() {
                    @Override
                    public PsychoSocialBefore mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        if (!rs.isBeforeFirst()) {
                            return null;
                        } else {
                            PsychoSocialBefore selectedPsBefore = new PsychoSocialBefore(
                                    patient_id,
                                    rs.getInt("pain_xpos"),
                                    rs.getInt("pain_ypos"),
                                    rs.getInt("familiy_xpos"),
                                    rs.getInt("familiy_ypos"),
                                    rs.getInt("work_xpos"),
                                    rs.getInt("work_ypos"),
                                    rs.getInt("finance_xpos"),
                                    rs.getInt("finance_ypos"),
                                    rs.getInt("event_xpos"),
                                    rs.getInt("event_ypos")
                            );
                            return selectedPsBefore;
                        }
                    }
                });
    }

    @Override
    public int deletePsychoSocialBeforeByPatientId(int patient_id) {
        String sql = "DELETE FROM PsychoSocialBefore WHERE patient_id = ?";
        Object[] args = new Object[] {patient_id};
        return jdbcTemplate.update(sql, args);    }

    @Override
    public int updatePsychoSocialBeforeByPatientId(int patient_id, PsychoSocialBefore psBefore) {
        String sql = "UPDATE PsychoSocialBefore SET pain_xpos = ?, pain_ypos = ?, familiy_xpos = ?, familiy_ypos = ?, work_xpos = ?, work_ypos = ?, finance_xpos= ?, finance_ypos = ?, event_xpos = ?, event_ypos = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                psBefore.getPain_xpos(), psBefore.getPain_ypos(),
                psBefore.getFamily_xpos(), psBefore.getFamily_ypos(),
                psBefore.getWork_xpos(), psBefore.getWork_ypos(),
                psBefore.getFinance_xpos(), psBefore.getFinance_ypos(),
                psBefore.getEvent_xpos(), psBefore.getEvent_ypos(),
                patient_id);
    }

    @Override
    public int insertPsychoSocialAfter(PsychoSocialAfter psAfter) {
        final String sql = "INSERT INTO PsychoSocialAfter (patient_id, pain_xpos, pain_ypos, familiy_xpos, familiy_ypos, work_xpos, work_ypos, finance_xpos, finance_ypos, event_xpos, event_ypos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                psAfter.getPatient_id(),
                psAfter.getPain_xpos(), psAfter.getPain_ypos(),
                psAfter.getFamily_xpos(), psAfter.getFamily_ypos(),
                psAfter.getWork_xpos(), psAfter.getWork_ypos(),
                psAfter.getFinance_xpos(), psAfter.getFinance_ypos(),
                psAfter.getEvent_xpos(), psAfter.getEvent_ypos()
        );
    }

    @Override
    public List<PsychoSocialAfter> selectAllPsychoSocialAfters() {
        final String sql = "SELECT * FROM PsychoSocialAfter ORDER BY patient_id";
        List<PsychoSocialAfter> allPsAfter = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int pain_xpos = resultSet.getInt("pain_xpos");
            int pain_ypos = resultSet.getInt("pain_ypos");
            int familiy_xpos = resultSet.getInt("familiy_xpos");
            int familiy_ypos = resultSet.getInt("familiy_ypos");
            int work_xpos = resultSet.getInt("work_xpos");
            int work_ypos = resultSet.getInt("work_ypos");
            int finance_xpos = resultSet.getInt("finance_xpos");
            int finance_ypos = resultSet.getInt("finance_ypos");
            int event_xpos = resultSet.getInt("event_xpos");
            int event_ypos = resultSet.getInt("event_ypos");
            return new PsychoSocialAfter(patient_id, pain_xpos, pain_ypos, familiy_xpos, familiy_ypos, work_xpos, work_ypos, finance_xpos, finance_ypos, event_xpos, event_ypos);
        });
        return allPsAfter;
    }

    @Override
    public PsychoSocialAfter selectPsychoSocialAfterByPatientId(int patient_id) {
        String sql = "SELECT * FROM PsychoSocialAfter WHERE patient_id = ?";

        return (PsychoSocialAfter) jdbcTemplate.queryForObject(
                sql,
                new Object[] {patient_id},
                new RowMapper<PsychoSocialAfter>() {
                    @Override
                    public PsychoSocialAfter mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        if (!rs.isBeforeFirst() ) {
                            return null;
                        } else {
                            PsychoSocialAfter selectedPsAfter = new PsychoSocialAfter(
                                    patient_id,
                                    rs.getInt("pain_xpos"),
                                    rs.getInt("pain_ypos"),
                                    rs.getInt("familiy_xpos"),
                                    rs.getInt("familiy_ypos"),
                                    rs.getInt("work_xpos"),
                                    rs.getInt("work_ypos"),
                                    rs.getInt("finance_xpos"),
                                    rs.getInt("finance_ypos"),
                                    rs.getInt("event_xpos"),
                                    rs.getInt("event_ypos")
                            );
                            return selectedPsAfter;
                        }
                    }
                });
    }

    @Override
    public int deletePsychoSocialAfterByPatientId(int patient_id) {
        String sql = "DELETE FROM PsychoSocialAfter WHERE patient_id = ?";
        Object[] args = new Object[] {patient_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updatePsychoSocialAfterByPatientId(int patient_id, PsychoSocialAfter psAfter) {
        String sql = "UPDATE PsychoSocialAfter SET pain_xpos = ?, pain_ypos = ?, familiy_xpos = ?, familiy_ypos = ?, work_xpos = ?, work_ypos = ?, finance_xpos= ?, finance_ypos = ?, event_xpos = ?, event_ypos = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                psAfter.getPain_xpos(), psAfter.getPain_ypos(),
                psAfter.getFamily_xpos(), psAfter.getFamily_ypos(),
                psAfter.getWork_xpos(), psAfter.getWork_ypos(),
                psAfter.getFinance_xpos(), psAfter.getFinance_ypos(),
                psAfter.getEvent_xpos(), psAfter.getEvent_ypos(),
                patient_id);
    }

    @Override
    public int insertImprovementReason(ImprovementReason improvementReason) {
        final String sql = "INSERT INTO ImprovementReason (patient_id, drugs, exercises, awareness, other_reason, other_reason_text) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                improvementReason.getPatient_id(),
                improvementReason.isDrugs(),
                improvementReason.isExercises(),
                improvementReason.isAwareness(),
                improvementReason.isOther_reason(), improvementReason.getOther_reason_text()
        );
    }

    @Override
    public List<ImprovementReason> selectAllImprovementReasons() {
        final String sql = "SELECT * FROM ImprovementReason ORDER BY patient_id";
        List<ImprovementReason> allImprovementReasons = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            boolean drugs = resultSet.getBoolean("drugs");
            boolean exercises = resultSet.getBoolean("exercises");
            boolean awareness = resultSet.getBoolean("awareness");
            boolean other_reason = resultSet.getBoolean("other_reason");
            String other_reason_text = resultSet.getString("other_reason_text");
            return new ImprovementReason(patient_id, drugs, exercises, awareness, other_reason, other_reason_text);
        });
        return allImprovementReasons;
    }

    @Override
    public ImprovementReason selectImprovementReasonByPatientId(int patient_id) {
        String sql = "SELECT * FROM ImprovementReason WHERE patient_id = ?";

        return (ImprovementReason) jdbcTemplate.queryForObject(
                sql,
                new Object[] {patient_id},
                new RowMapper<ImprovementReason>() {
                    @Override
                    public ImprovementReason mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        if (!rs.isBeforeFirst() ) {
                            return null;
                        } else{
                            ImprovementReason selectedImprovementReason = new ImprovementReason(
                                    patient_id,
                                    rs.getBoolean("drugs"),
                                    rs.getBoolean("exercises"),
                                    rs.getBoolean("awareness"),
                                    rs.getBoolean("other_reason"),
                                    rs.getString("other_reason_text")
                            );
                            return selectedImprovementReason;
                        }
                    }
                });
    }

    @Override
    public int deleteImprovementReasonByPatientId(int patient_id) {
        String sql = "DELETE FROM ImprovementReason WHERE patient_id = ?";
        Object[] args = new Object[] {patient_id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateImprovementReasonByPatientId(int patient_id, ImprovementReason improvementReason) {
        String sql = "UPDATE ImprovementReason SET drugs = ?, exercises = ?, awareness = ?, other_reason = ?, other_reason_text = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                improvementReason.isDrugs(),
                improvementReason.isExercises(),
                improvementReason.isAwareness(),
                improvementReason.isOther_reason(), improvementReason.getOther_reason_text(),
                patient_id);
    }
}
