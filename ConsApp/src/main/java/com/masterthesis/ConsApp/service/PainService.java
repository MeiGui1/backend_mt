package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.PainDao;
import com.masterthesis.ConsApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PainService {

    private final PainDao painDao;

    @Autowired
    public PainService(@Qualifier("painRepository") PainDao painDao) {
        this.painDao = painDao;
    }

    public int addPainBeginning(PainBeginning painBeginning) {
        return painDao.insertPainBeginning(painBeginning);
    }

    public List<PainBeginning> getAllPainBeginnings() {
        return painDao.selectAllPainBeginnings();
    }

    public boolean existsPainBeginning(int patient_id) {
        return painDao.existsPainBeginning(patient_id);
    }

    public PainBeginning getPainBeginningById(int patient_id) {
        return painDao.selectPainBeginningByPatientId(patient_id);

    }

    public int deletePainBeginning(int patient_id) {
        return painDao.deletePainBeginningByPatientId(patient_id);
    }

    public int updatePainBeginning(int patient_id, PainBeginning painBeginningToUpdate) {
        return painDao.updatePainBeginningByPatientId(patient_id, painBeginningToUpdate);
    }




    public int addPainCurrent(PainCurrent painCurrent) {
        return painDao.insertPainCurrent(painCurrent);
    }

    public List<PainCurrent> getAllPainCurrents() {
        return painDao.selectAllPainCurrents();

    }

    public boolean existsPainCurrent(int patient_id) {
        return painDao.existsPainCurrent(patient_id);

    }

    public PainCurrent getPainCurrentById(int patient_id) {
        return painDao.selectPainCurrentByPatientId(patient_id);

    }

    public int deletePainCurrent(int patient_id) {
        return painDao.deletePainCurrentByPatientId(patient_id);

    }

    public int updatePainCurrent(int patient_id, PainCurrent painCurrentToUpdate) {
        return painDao.updatePainCurrentByPatientId(patient_id, painCurrentToUpdate);
    }
}
