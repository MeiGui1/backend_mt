package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.PsychoSocialDao;
import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.PsychoSocialAfter;
import com.masterthesis.ConsApp.model.PsychoSocialBefore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsychoSocialService {

    private final PsychoSocialDao psychoSocialDao;

    @Autowired
    public PsychoSocialService(@Qualifier("psychosocialRepository") PsychoSocialDao psychoSocialDao) {
        this.psychoSocialDao = psychoSocialDao;
    }

    public int addPsychoSocialBefore(PsychoSocialBefore psychoSocialBefore){
        return psychoSocialDao.insertPsychoSocialBefore(psychoSocialBefore);
    }

    public List<PsychoSocialBefore> getAllPsychoSocialBefores(){
        return psychoSocialDao.selectAllPsychoSocialBefores();
    }

    public PsychoSocialBefore getPsychoSocialBeforeById(int id){
        return psychoSocialDao.selectPsychoSocialBeforeByPatientId(id);
    }

    public int deletePsychoSocialBefore(int id){
        return psychoSocialDao.deletePsychoSocialBeforeByPatientId(id);
    }

    public int updatePsychoSocialBefore(int id, PsychoSocialBefore newPsychoSocialBefore){
        return psychoSocialDao.updatePsychoSocialBeforeByPatientId(id, newPsychoSocialBefore);
    }





    public int addPsychoSocialAfter(PsychoSocialAfter psychoSocialAfter){
        return psychoSocialDao.insertPsychoSocialAfter(psychoSocialAfter);
    }

    public List<PsychoSocialAfter> getAllPsychoSocialAfters(){
        return psychoSocialDao.selectAllPsychoSocialAfters();
    }

    public PsychoSocialAfter getPsychoSocialAfterById(int id){
        return psychoSocialDao.selectPsychoSocialAfterByPatientId(id);
    }

    public int deletePsychoSocialAfter(int id){
        return psychoSocialDao.deletePsychoSocialAfterByPatientId(id);
    }

    public int updatePsychoSocialAfter(int id, PsychoSocialAfter newPsychoSocialAfter){
        return psychoSocialDao.updatePsychoSocialAfterByPatientId(id, newPsychoSocialAfter);
    }




    public int addImprovementReason(ImprovementReason improvementReason){
        return psychoSocialDao.insertImprovementReason(improvementReason);
    }

    public List<ImprovementReason> getAllImprovementReasons(){
        return psychoSocialDao.selectAllImprovementReasons();
    }

    public ImprovementReason getImprovementReasonById(int id){
        return psychoSocialDao.selectImprovementReasonByPatientId(id);
    }

    public int deleteImprovementReason(int id){
        return psychoSocialDao.deleteImprovementReasonByPatientId(id);
    }

    public int updateImprovementReason(int id, ImprovementReason newImprovementReason){
        return psychoSocialDao.updateImprovementReasonByPatientId(id, newImprovementReason);
    }



}
