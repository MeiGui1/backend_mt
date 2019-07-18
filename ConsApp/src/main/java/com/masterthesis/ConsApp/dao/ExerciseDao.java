package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ExerciseType;
import com.masterthesis.ConsApp.model.PatientExercise;

import java.util.List;

public interface ExerciseDao {

    /*ExerciseType table related functions*/

    int insertExerciseType(ExerciseType ExerciseType);
    List<ExerciseType> selectAllExerciseTypes();
    List<String> selectAllExerciseTypeTitles();
    ExerciseType selectExerciseTypeByTitle(String title);
    int deleteExerciseTypeByTitle(String title);
    int updateExerciseType(String title, ExerciseType ExerciseType);


    /*PatientExercise table related functions*/

    int insertPatientExercise(PatientExercise patientExercise);
    List<PatientExercise> selectAllPatientExercises();
    List<PatientExercise> selectAllExercisesOfPatient(int patient_id);
    int deleteExerciseOfPatient(int patient_id, String exercisetype_title);
}
