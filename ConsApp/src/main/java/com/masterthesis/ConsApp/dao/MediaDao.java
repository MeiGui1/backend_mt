package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.*;

import java.util.List;

public interface MediaDao {

    /*PatientImage table related functions*/

    int insertPatientImage(PatientImage patientImage);
    List<PatientImage> selectAllPatientImages();
    List<String> selectAllImagePathsOfPatient(int patient_id);
    int deletePatientImage(int patient_id, String path);

    /*PatientVideo table related functions*/

    int insertPatientVideo(PatientVideo patientVideo);
    List<PatientVideo> selectAllPatientVideos();
    List<String> selectAllVideoPathsOfPatient(int patient_id);
    int deletePatientVideo(int patient_id, String path);

    /*PatientDocument table related functions*/

    int insertPatientDocument(PatientDocument patientDocument);
    List<PatientDocument> selectAllPatientDocuments();
    List<String> selectAllDocumentPathsOfPatient(int patient_id);
    int deletePatientDocument(int patient_id, String path);

    /*WebsiteType table related functions*/

    int insertWebsiteType(WebsiteType websiteType);
    List<WebsiteType> selectAllWebsiteTypes();
    WebsiteType selectWebsiteTypeById(int id);
    int deleteWebsiteTypeById(int id);
    int updateWebsiteTypeById(int id, WebsiteType websiteType);
    int selectLastWebsiteId();

    /*PatientWebsite table related functions*/

    int insertPatientWebsite(PatientWebsite patientWebsite);
    List<PatientWebsite> selectAllPatientWebsites();
    List<Integer> selectAllWebsiteIdsOfPatient(int patient_id);
    int deletePatientWebsiteByIds(int patient_id, int website_id);
}
