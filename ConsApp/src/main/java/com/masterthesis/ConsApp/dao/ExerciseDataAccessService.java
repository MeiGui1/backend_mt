package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ExercisePhoto;
import com.masterthesis.ConsApp.model.ExerciseType;
import com.masterthesis.ConsApp.model.PatientExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("exerciseRepository")
public class ExerciseDataAccessService implements ExerciseDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //ExerciseType related

    @Override
    public int insertExerciseType(ExerciseType exerciseType) {
        final String sql = "INSERT INTO ExerciseType (title, explanation) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                exerciseType.getTitle(), exerciseType.getExplanation()
        );
    }

    @Override
    public List<ExerciseType> selectAllExerciseTypes() {
        final String sql = "SELECT * FROM ExerciseType ORDER BY title";
        List<ExerciseType> allExerciseTypes = jdbcTemplate.query(sql, (resultSet, i) -> {
            String title = resultSet.getString("title");
            String explanation = resultSet.getString("explanation");
            return new ExerciseType(title, explanation);
        });
        return allExerciseTypes;
    }

    @Override
    public List<String> selectAllExerciseTypeTitles() {
        final String sql = "SELECT DISTINCT title FROM ExerciseType ORDER BY title";
        List<String> allExerciseTypeTitles = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getString("title"));
        return allExerciseTypeTitles;
    }

    @Override
    public ExerciseType selectExerciseTypeByTitle(String title) {
        String sql = "SELECT * FROM ExerciseType WHERE title = ?";
        return (ExerciseType) jdbcTemplate.queryForObject(
                sql,
                new Object[]{title},
                new RowMapper<ExerciseType>() {
                    @Override
                    public ExerciseType mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        ExerciseType selectedExerciseType = new ExerciseType(title,
                                rs.getString("explanation"));
                        return selectedExerciseType;
                    }
                });
    }

    @Override
    public int deleteExerciseTypeByTitle(String title) {
        String sql = "DELETE FROM ExerciseType WHERE title = ?";
        Object[] args = new Object[]{title};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateExerciseTypeByTitle(String title, ExerciseType exerciseType) {
        String sql = "UPDATE ExerciseType SET explanation = ? WHERE title = ?";
        return jdbcTemplate.update(sql, exerciseType.getExplanation(), title);
    }


    //PatientExercise related

    @Override
    public int insertPatientExercise(PatientExercise patientExercise) {
        final String sql = "INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patientExercise.getPatient_id(), patientExercise.getExercisetype_title()
        );
    }

    @Override
    public List<PatientExercise> selectAllPatientExercises() {
        final String sql = "SELECT * FROM PatientExercise ORDER BY patient_id";
        List<PatientExercise> allPatientExercises = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            String exercisetype_title = resultSet.getString("exercisetype_title");
            return new PatientExercise(patient_id, exercisetype_title);
        });
        return allPatientExercises;
    }

    @Override
    public List<PatientExercise> selectAllExercisesOfPatient(int patient_id) {
        final String sql = "SELECT * FROM PatientExercise WHERE patient_id = " + patient_id;
        List<PatientExercise> allExercisesOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            String exercisetype_title = resultSet.getString("exercisetype_title");
            return new PatientExercise(patient_id, exercisetype_title);
        });
        return allExercisesOfPatient;
    }

    @Override
    public int deleteExerciseOfPatient(int patient_id, String exercisetype_title) {
        String sql = "DELETE FROM PatientExercise WHERE patient_id = ? AND exercisetype_title = ?";
        Object[] args = new Object[]{patient_id, exercisetype_title};
        return jdbcTemplate.update(sql, args);
    }



    //ExercisePhoto related

    @Override
    public int insertExercisePhoto(ExercisePhoto exercisePhoto) {
        final String sql = "INSERT INTO ExercisePhoto (patient_id, photo) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                exercisePhoto.getPatient_id(), exercisePhoto.getPhoto()
        );
    }

    @Override
    public List<ExercisePhoto> selectAllExercisePhotos() {
        final String sql = "SELECT * FROM ExercisePhoto ORDER BY patient_id";
        List<ExercisePhoto> allExercisePhotos = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            int patient_id = resultSet.getInt("patient_id");
            byte[] photo = resultSet.getBytes("photo");
            return new ExercisePhoto(id, patient_id, photo);
        });
        return allExercisePhotos;
    }

    @Override
    public List<ExercisePhoto> selectAllExercisePhotosOfPatient(int patient_id) {
        final String sql = "SELECT * FROM ExercisePhoto WHERE patient_id = " + patient_id;
        List<ExercisePhoto> allExercisesPhotosOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            byte[] photo = resultSet.getBytes("photo");
            return new ExercisePhoto(id, patient_id, photo);
        });
        return allExercisesPhotosOfPatient;
    }

    @Override
    public int deleteExercisePhotoById(int id) {
        String sql = "DELETE FROM ExercisePhoto WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args);
    }
}
