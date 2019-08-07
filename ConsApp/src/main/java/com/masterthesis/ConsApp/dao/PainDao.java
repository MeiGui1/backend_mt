package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.ImprovementReason;
import com.masterthesis.ConsApp.model.PainBeginning;
import com.masterthesis.ConsApp.model.PainCurrent;
import com.masterthesis.ConsApp.model.PainBeginning;

import java.util.List;

public interface PainDao {

    /*PainBeginning table related functions*/

    int insertPainBeginning(PainBeginning painBeginning);
    List<PainBeginning> selectAllPainBeginnings();
    PainBeginning selectPainBeginningByPatientId(int patient_id);
    int deletePainBeginningByPatientId(int patient_id);
    int updatePainBeginningByPatientId(int patient_id, PainBeginning painBeginning);
    boolean existsPainBeginning(int patient_id);


    /*PainCurrent table related functions*/

    int insertPainCurrent(PainCurrent painCurrent);
    List<PainCurrent> selectAllPainCurrents();
    PainCurrent selectPainCurrentByPatientId(int patient_id);
    int deletePainCurrentByPatientId(int patient_id);
    int updatePainCurrentByPatientId(int patient_id, PainCurrent painCurrent);
    boolean existsPainCurrent(int patient_id);

}
