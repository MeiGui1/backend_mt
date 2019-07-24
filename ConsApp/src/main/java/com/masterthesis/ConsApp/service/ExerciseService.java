package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.ExerciseDao;
import com.masterthesis.ConsApp.dao.ExerciseDao;
import com.masterthesis.ConsApp.model.ExercisePhoto;
import com.masterthesis.ConsApp.model.ExerciseType;
import com.masterthesis.ConsApp.model.PatientExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseDao exerciseDao;

    @Autowired
    public ExerciseService(@Qualifier("exerciseRepository") ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    /*ExerciseType table related functions*/

    public int addExerciseType(ExerciseType exerciseType) {
        return exerciseDao.insertExerciseType(exerciseType);
    }

    public List<ExerciseType> getAllExerciseTypes() {
        return exerciseDao.selectAllExerciseTypes();
    }

    public List<String> getExerciseTypesTitles() {
        return exerciseDao.selectAllExerciseTypeTitles();
    }

    public ExerciseType getExerciseTypeByTitle(String title) {
        return exerciseDao.selectExerciseTypeByTitle(title);
    }

    public int deleteExerciseType(String title) {
        return exerciseDao.deleteExerciseTypeByTitle(title);
    }

    public int updateExerciseType(String title, ExerciseType exerciseType) {
        return exerciseDao.updateExerciseTypeByTitle(title, exerciseType);
    }



    /*PatientExercise table related functions*/

    public int addPatientExercise(PatientExercise patientExercise) {
        return exerciseDao.insertPatientExercise(patientExercise);
    }

    public List<PatientExercise> getAllPatientExercises() {
        return exerciseDao.selectAllPatientExercises();
    }

    public List<PatientExercise> getAllExercisesOfPatient(int patient_id) {
        return exerciseDao.selectAllExercisesOfPatient(patient_id);
    }

    public int deletePatientExercise(int patient_id, String exercisetype_title) {
        return exerciseDao.deleteExerciseOfPatient(patient_id, exercisetype_title);
    }



    /*ExercisePhoto related functions*/

    public int addExercisePhoto(ExercisePhoto exercisePhoto) {
        return exerciseDao.insertExercisePhoto(exercisePhoto);
    }

    public List<ExercisePhoto> getAllExercisePhotos() {
        return exerciseDao.selectAllExercisePhotos();
    }

    public List<ExercisePhoto> getAllExercisePhotosOfPatient(int patient_id) {
        return exerciseDao.selectAllExercisePhotosOfPatient(patient_id);
    }

    public int deleteExercisePhoto(int id) {
        return exerciseDao.deleteExercisePhotoById(id);
    }

    public int getLastId(){
        return  exerciseDao.selectLastPhotoId();
    }
}
