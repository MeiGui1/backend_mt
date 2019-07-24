package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.ExercisePhoto;
import com.masterthesis.ConsApp.model.ExerciseType;
import com.masterthesis.ConsApp.model.PatientExercise;
import com.masterthesis.ConsApp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1")
@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    //ExerciseType Services

    @PostMapping(path = "/exercisetype")
    public void addExerciseType(@RequestBody ExerciseType exerciseType){
        exerciseService.addExerciseType(exerciseType);
    }

    @GetMapping(path = "/exercisetype")
    public List<ExerciseType> getAllExerciseTypes(){
        return exerciseService.getAllExerciseTypes();
    }

    @GetMapping(path = "/exercisetype/title={title}")
    public ExerciseType getExerciseTypesByTitle(@PathVariable("title") String title){
        return exerciseService.getExerciseTypeByTitle(title);
    }

    @GetMapping(path = "/exercisetype/title")
    public List<String> getAllExerciseTypeTitles(){
        return exerciseService.getExerciseTypesTitles();
    }

    @DeleteMapping(path = "/exercisetype/{title}")
    public void deleteExerciseType(@PathVariable("title") String title){
        exerciseService.deleteExerciseType(title);
    }

    @PutMapping(path = "/exercisetype/{title}")
    public void updateExerciseType(@PathVariable("title") String title, @Valid @NotNull @RequestBody ExerciseType exerciseType){
        exerciseService.updateExerciseType(title, exerciseType);
    }


    //PatientExercise Services

    @PostMapping(path = "/patientexercise")
    public void addPatientExercise(@RequestBody PatientExercise patientExercise){
        exerciseService.addPatientExercise(patientExercise);
    }

    @GetMapping(path = "/patientexercise")
    public List<PatientExercise> getAllPatientExercises(){
        return exerciseService.getAllPatientExercises();
    }

    @GetMapping(path = "/patientexercise/{id}")
    public List<PatientExercise> getAllExercisesOfPatient(@PathVariable("id") int id){
        return exerciseService.getAllExercisesOfPatient(id);
    }

    @DeleteMapping(path = "/patientexercise/{patient_id}/{exercisetype_title}")
    public void deletePatientExercise(@PathVariable("patient_id") int patient_id, @PathVariable("exercisetype_title") String exercisetype_title){
        exerciseService.deletePatientExercise(patient_id, exercisetype_title);
    }


    //ExercisePhoto Services

    @PostMapping(path = "/exercisephoto")
    public void addExercisePhoto(@RequestBody ExercisePhoto exercisePhoto){
        exerciseService.addExercisePhoto(exercisePhoto);
    }

    @GetMapping(path = "/exercisephoto")
    public List<ExercisePhoto> getAllExercisePhotos(){
        return exerciseService.getAllExercisePhotos();
    }

    @GetMapping(path = "/exercisephoto/{id}")
    public List<ExercisePhoto> getAllExercisePhotosOfPatient(@PathVariable("id") int id){
        return exerciseService.getAllExercisePhotosOfPatient(id);
    }

    @DeleteMapping(path = "/exercisephoto/{id}}")
    public void deleteExercisePhoto(@PathVariable("id") int id){
        exerciseService.deleteExercisePhoto(id);
    }

    @GetMapping(path = "/exercisephoto_last_id")
    public int getLastPhotoId(){
        return exerciseService.getLastId();
    }

}
