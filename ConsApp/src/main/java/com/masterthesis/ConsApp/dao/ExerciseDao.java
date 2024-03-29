package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ExercisePhoto;
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
    int updateExerciseTypeByTitle(String title, ExerciseType ExerciseType);


    /*PatientExercise table related functions*/
    int insertPatientExercise(PatientExercise patientExercise);
    List<PatientExercise> selectAllPatientExercises();
    List<PatientExercise> selectAllExercisesOfPatient(int patient_id);
    int deleteExerciseOfPatient(int patient_id, String exercisetype_title);

    /*ExercisePhoto related functions*/
    int insertExercisePhoto(ExercisePhoto exercisePhoto);
    List<ExercisePhoto> selectAllExercisePhotos();
    List<ExercisePhoto> selectAllExercisePhotosOfPatient(int patient_id);
    int deleteExercisePhotoById(int id);
    int selectLastPhotoId();
}
