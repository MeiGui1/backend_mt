package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.PsychoSocialAfter;
import com.masterthesis.ConsApp.model.PatientDrug;
import com.masterthesis.ConsApp.model.PsychoSocialBefore;

import java.util.List;

public interface PsychoSocialDao {

    /*PsychoSocialBefore table related functions*/

    int insertPsychoSocialBefore(PsychoSocialBefore psychoSocialBefore);
    List<PsychoSocialBefore> selectAllPsychoSocialBefores();
    PsychoSocialBefore selectPsychoSocialBeforeByPatientId(int patient_id);
    int deletePsychoSocialBeforeByPatientId(int patient_id);
    int updatePsychoSocialBeforeByPatientId(int patient_id, PsychoSocialBefore psychoSocialBefore);
    boolean existsPsychoScialBefore(int patient_id);


    /*PsychoSocialAfter table related functions*/

    int insertPsychoSocialAfter(PsychoSocialAfter psychoSocialAfter);
    List<PsychoSocialAfter> selectAllPsychoSocialAfters();
    PsychoSocialAfter selectPsychoSocialAfterByPatientId(int patient_id);
    int deletePsychoSocialAfterByPatientId(int patient_id);
    int updatePsychoSocialAfterByPatientId(int patient_id, PsychoSocialAfter psychoSocialAfter);
    boolean existsPsychoScialAfter(int patient_id);


    /*ImprovementReason table related functions*/
    int insertImprovementReason(ImprovementReason improvementReason);
    List<ImprovementReason> selectAllImprovementReasons();
    ImprovementReason selectImprovementReasonByPatientId(int patient_id);
    int deleteImprovementReasonByPatientId(int patient_id);
    int updateImprovementReasonByPatientId(int patient_id, ImprovementReason improvementReason);
    boolean existsImprovementReason(int patient_id);

}
