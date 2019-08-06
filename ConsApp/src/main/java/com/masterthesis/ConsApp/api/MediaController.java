package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.*;
import com.masterthesis.ConsApp.service.DrugService;
import com.masterthesis.ConsApp.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1")
@RestController
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    //PatientImage related

    @PostMapping(path = "/patientimage")
    public void addPatientImage(@RequestBody PatientImage patientImage){
        mediaService.addPatientImage(patientImage);
    }

    @GetMapping(path = "/patientimage")
    public List<PatientImage> getAllPatientImages(){
        return mediaService.getAllPatientImages();
    }

    @GetMapping(path = "/patientimage/{patient_id}")
    public List<String> getAllImagesOfPatient(@PathVariable("patient_id") int patient_id){
        return mediaService.getAllImagePathsOfPatient(patient_id);
    }

    @DeleteMapping(path = "/patientimage")
    public void deleteImageTypeById(@RequestBody PatientImage patientImage){
        mediaService.deletePatientImage(patientImage.getPatient_id(), patientImage.getImage_path());
    }


    //PatientVideo related

    @PostMapping(path = "/patientvideo")
    public void addPatientVideo(@RequestBody PatientVideo patientVideo){
        mediaService.addPatientVideo(patientVideo);
    }

    @GetMapping(path = "/patientvideo")
    public List<PatientVideo> getAllPatientVideos(){
        return mediaService.getAllPatientVideos();
    }

    @GetMapping(path = "/patientvideo/{patient_id}")
    public List<String> getAllVideosOfPatient(@PathVariable("patient_id") int patient_id){
        return mediaService.getAllVideoPathsOfPatient(patient_id);
    }

    @DeleteMapping(path = "/patientvideo")
    public void deleteVideoTypeById(@RequestBody PatientVideo patientVideo){
        mediaService.deletePatientVideo(patientVideo.getPatient_id(), patientVideo.getVideo_path());
    }


    //PatientDocument related

    @PostMapping(path = "/patientdocument")
    public void addPatientDocument(@RequestBody PatientDocument patientDocument){
        mediaService.addPatientDocument(patientDocument);
    }

    @GetMapping(path = "/patientdocument")
    public List<PatientDocument> getAllPatientDocuments(){
        return mediaService.getAllPatientDocuments();
    }

    @GetMapping(path = "/patientdocument/{patient_id}")
    public List<String> getAllDocumentsOfPatient(@PathVariable("patient_id") int patient_id){
        return mediaService.getAllDocumentPathsOfPatient(patient_id);
    }

    @DeleteMapping(path = "/patientdocument")
    public void deleteDocumentTypeById(@RequestBody PatientDocument patientDocument){
        mediaService.deletePatientDocument(patientDocument.getPatient_id(), patientDocument.getDocument_path());
    }


    //WebsiteType related

    @PostMapping(path = "/websitetype")
    public void addWebsiteType(@RequestBody WebsiteType websiteType){
        mediaService.addWebsiteType(websiteType);
    }

    @GetMapping(path = "/websitetype")
    public List<WebsiteType> getAllWebsiteTypes(){
        return mediaService.getAllWebsiteTypes();
    }

    @GetMapping(path = "/websitetype/{id}")
    public WebsiteType getWebsiteTypeById(@PathVariable("id") int id){
        return mediaService.getWebsiteTypeById(id);
    }

    @DeleteMapping(path = "/websitetype/{id}")
    public void deleteWebsiteTypeById(@PathVariable("id") int id){
        mediaService.deleteWebsiteType(id);
    }

    @PutMapping(path = "/websitetype/{id}")
    public void updateWebsiteType(@PathVariable("id") int id, @Valid @NotNull @RequestBody WebsiteType websiteType){
        mediaService.updateWebsiteType(id, websiteType);
    }

    @GetMapping(path = "/websitetype_last_id")
    public int getLastWebsiteTypeId(){
        return mediaService.getLastWebsiteTypeId();
    }


    //PatientWebsite related

    @PostMapping(path = "/patientwebsite")
    public void addPatientWebsite(@RequestBody PatientWebsite patientWebsite){
        mediaService.addPatientWebsite(patientWebsite);
    }

    @GetMapping(path = "/patientwebsite")
    public List<PatientWebsite> getAllPatientWebsites(){
        return mediaService.getAllPatientWebsites();
    }

    @GetMapping(path = "/patientwebsite/{patient_id}")
    public List<Integer> getAllWebsitesOfPatient(@PathVariable("patient_id") int patient_id){
        return mediaService.getAllWebsiteIdsOfPatient(patient_id);
    }

    @DeleteMapping(path = "/patientwebsite")
    public void deletePatientWebsiteByIds(@RequestBody PatientWebsite patientWebsite){
        mediaService.deletePatientWebsite(patientWebsite.getPatient_id(), patientWebsite.getWebsite_id());
    }

}
