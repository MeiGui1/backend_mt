package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.DiagnosisDao;
import com.masterthesis.ConsApp.dao.MediaDao;
import com.masterthesis.ConsApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    private final MediaDao mediaDao;

    @Autowired
    public MediaService(@Qualifier("mediaRepository") MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    /*PatientImage table related functions*/

    public int addPatientImage(PatientImage patientImage) {
        return mediaDao.insertPatientImage(patientImage);
    }

    public List<PatientImage> getAllPatientImages() {
        return mediaDao.selectAllPatientImages();
    }

    public List<String> getAllImagePathsOfPatient(int patient_id) {
        return mediaDao.selectAllImagePathsOfPatient(patient_id);
    }

    public int deletePatientImage(int patient_id, String path) {
        return mediaDao.deletePatientImage(patient_id, path);
    }


    /*PatientVideo table related functions*/

    public int addPatientVideo(PatientVideo patientVideo) {
        return mediaDao.insertPatientVideo(patientVideo);
    }

    public List<PatientVideo> getAllPatientVideos() {
        return mediaDao.selectAllPatientVideos();
    }

    public List<String> getAllVideoPathsOfPatient(int patient_id) {
        return mediaDao.selectAllVideoPathsOfPatient(patient_id);
    }

    public int deletePatientVideo(int patient_id, String path) {
        return mediaDao.deletePatientVideo(patient_id, path);
    }


    /*PatientDocument table related functions*/

    public int addPatientDocument(PatientDocument patientDocument) {
        return mediaDao.insertPatientDocument(patientDocument);
    }

    public List<PatientDocument> getAllPatientDocuments() {
        return mediaDao.selectAllPatientDocuments();
    }

    public List<String> getAllDocumentPathsOfPatient(int patient_id) {
        return mediaDao.selectAllDocumentPathsOfPatient(patient_id);
    }

    public int deletePatientDocument(int patient_id, String path) {
        return mediaDao.deletePatientDocument(patient_id, path);
    }


    /*WebsiteType table related functions*/

    public int addWebsiteType(WebsiteType websiteType) {
        return mediaDao.insertWebsiteType(websiteType);
    }

    public List<WebsiteType> getAllWebsiteTypes() {
        return mediaDao.selectAllWebsiteTypes();
    }

    public WebsiteType getWebsiteTypeById(int id){
        return mediaDao.selectWebsiteTypeById(id);
    }

    public int deleteWebsiteType(int id) {
        return mediaDao.deleteWebsiteTypeById(id);
    }
    public int updateWebsiteType(int id, WebsiteType websiteType) {
        return mediaDao.updateWebsiteTypeById(id, websiteType);
    }

    public int getLastWebsiteTypeId(){
        return mediaDao.selectLastWebsiteId();
    }

    /*PatientWebsite table related functions*/

    public int addPatientWebsite(PatientWebsite patientWebsite) {
        return mediaDao.insertPatientWebsite(patientWebsite);
    }

    public List<PatientWebsite> getAllPatientWebsites() {
        return mediaDao.selectAllPatientWebsites();
    }

    public List<Integer> getAllWebsiteIdsOfPatient(int patient_id) {
        return mediaDao.selectAllWebsiteIdsOfPatient(patient_id);
    }

    public int deletePatientWebsite(int patient_id, int website_id) {
        return mediaDao.deletePatientWebsiteByIds(patient_id, website_id);
    }
}
