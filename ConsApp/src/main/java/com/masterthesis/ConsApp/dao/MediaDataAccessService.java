package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("drugRepository")
public class MediaDataAccessService implements MediaDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //PatientImage related

    @Override
    public int insertPatientImage(PatientImage patientImage) {
        final String sql = "INSERT INTO PatientImage (patient_id, image_path) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patientImage.getPatient_id(), patientImage.getImage_path()
        );
    }

    @Override
    public List<PatientImage> selectAllPatientImages() {
        final String sql = "SELECT * FROM PatientImage ORDER BY patient_id";
        List<PatientImage> allPatientImages = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            String image_path = resultSet.getString("image_path");
            return new PatientImage(patient_id, image_path);
        });
        return allPatientImages;
    }

    @Override
    public List<String> selectAllImagePathsOfPatient(int patient_id) {
        final String sql = "SELECT image_path FROM PatientImage WHERE patient_id = "+ patient_id;
        List<String> allImagePathsOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getString("image_path"));
        return allImagePathsOfPatient;
    }

    @Override
    public int deletePatientImage(int patient_id, String path) {
        String sql = "DELETE FROM PatientImage WHERE patient_id = ? AND image_path = ?";
        Object[] args = new Object[] {patient_id, path};
        return jdbcTemplate.update(sql, args);
    }



    //PatientVideo related

    @Override
    public int insertPatientVideo(PatientVideo patientVideo) {
        final String sql = "INSERT INTO PatientVideo (patient_id, video_path) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patientVideo.getPatient_id(), patientVideo.getVideo_path()
        );
    }

    @Override
    public List<PatientVideo> selectAllPatientVideos() {
        final String sql = "SELECT * FROM PatientVideo ORDER BY patient_id";
        List<PatientVideo> allPatientVideos = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            String video_path = resultSet.getString("video_path");
            return new PatientVideo(patient_id, video_path);
        });
        return allPatientVideos;
    }

    @Override
    public List<String> selectAllVideoPathsOfPatient(int patient_id) {
        final String sql = "SELECT video_path FROM PatientVideo WHERE patient_id = "+ patient_id;
        List<String> allVideoPathsOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getString("video_path"));
        return allVideoPathsOfPatient;
    }

    @Override
    public int deletePatientVideo(int patient_id, String path) {
        String sql = "DELETE FROM PatientVideo WHERE patient_id = ? AND video_path = ?";
        Object[] args = new Object[] {patient_id, path};
        return jdbcTemplate.update(sql, args);
    }



    //PatientDocument related

    @Override
    public int insertPatientDocument(PatientDocument patientDocument) {
        final String sql = "INSERT INTO PatientDocument (patient_id, document_path) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patientDocument.getPatient_id(), patientDocument.getDocument_path()
        );
    }

    @Override
    public List<PatientDocument> selectAllPatientDocuments() {
        final String sql = "SELECT * FROM PatientDocument ORDER BY patient_id";
        List<PatientDocument> allPatientDocuments = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            String document_path = resultSet.getString("document_path");
            return new PatientDocument(patient_id, document_path);
        });
        return allPatientDocuments;
    }

    @Override
    public List<String> selectAllDocumentPathsOfPatient(int patient_id) {
        final String sql = "SELECT document_path FROM PatientDocument WHERE patient_id = "+ patient_id;
        List<String> allDocumentPathsOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getString("document_path"));
        return allDocumentPathsOfPatient;
    }

    @Override
    public int deletePatientDocument(int patient_id, String path) {
        String sql = "DELETE FROM PatientDocument WHERE patient_id = ? AND document_path = ?";
        Object[] args = new Object[] {patient_id, path};
        return jdbcTemplate.update(sql, args);
    }



    //WebsiteType related

    @Override
    public int insertWebsiteType(WebsiteType websiteType) {
        final String sql = "INSERT INTO WebsiteType (name, url, description) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                websiteType.getName(), websiteType.getUrl(), websiteType.getDescription()
        );
    }

    @Override
    public List<WebsiteType> selectAllWebsiteTypes() {
        final String sql = "SELECT * FROM WebsiteType ORDER BY name";
        List<WebsiteType> allWebsiteTypes = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String description = resultSet.getString("description");
            return new WebsiteType(id, name, url, description);
        });
        return allWebsiteTypes;
    }

    @Override
    public WebsiteType selectWebsiteTypeById(int id) {
        final String sql = "SELECT * FROM WebsiteType WHERE id = ?";
        return (WebsiteType) jdbcTemplate.queryForObject(
                sql,
                new Object[] {id},
                new RowMapper<WebsiteType>() {
                    @Override
                    public WebsiteType mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        WebsiteType selectedWebsiteType = new WebsiteType(
                                id,
                                rs.getString("name"),
                                rs.getString("url"),
                                rs.getString("description"));
                        return selectedWebsiteType;
                    }
                });
    }

    @Override
    public int deleteWebsiteTypeById(int id) {
        String sql = "DELETE FROM WebsiteType WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateWebsiteTypeById(int id, WebsiteType websiteType) {
        String sql = "UPDATE WebsiteType SET name = ?, url = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, websiteType.getName(), websiteType.getUrl(), websiteType.getDescription(), id);
    }

    @Override
    public int selectLastWebsiteId() {
        String sql = "SELECT max(id) FROM WebsiteType";
        int maxId = jdbcTemplate.queryForObject(sql, Integer.class);
        return maxId;
    }



    //PatientWebsite related

    @Override
    public int insertPatientWebsite(PatientWebsite patientWebsite) {
        final String sql = "INSERT INTO PatientWebsite (patient_id, website_id) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                patientWebsite.getPatient_id(), patientWebsite.getWebsite_id()
        );
    }

    @Override
    public List<PatientWebsite> selectAllPatientWebsites() {
        final String sql = "SELECT * FROM PatientWebsite ORDER BY patient_id";
        List<PatientWebsite> allPatientWebsites = jdbcTemplate.query(sql, (resultSet, i) -> {
            int patient_id = resultSet.getInt("patient_id");
            int website_id = resultSet.getInt("website_id");
            return new PatientWebsite(patient_id, website_id);
        });
        return allPatientWebsites;
    }

    @Override
    public List<Integer> selectAllWebsiteIdsOfPatient(int patient_id) {
        final String sql = "SELECT website_id FROM PatientWebsite WHERE patient_id = "+ patient_id;
        List<Integer> allWebsiteIdsOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> resultSet.getInt("website_id"));
        return allWebsiteIdsOfPatient;
    }

    @Override
    public int deletePatientWebsiteByIds(int patient_id, int website_id) {
        String sql = "DELETE FROM PatientWebsite WHERE patient_id = ? AND website_id = ?";
        Object[] args = new Object[] {patient_id, website_id};
        return jdbcTemplate.update(sql, args);    }
}
