package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Note;
import com.masterthesis.ConsApp.model.PatientDiagnosis;

import java.util.List;

public interface NoteDao {

    /*Note table related functions*/

    int insertNote(Note note);
    List<Note> selectAllNotes();
    List<Note> selectAllNotesOfPatient(int patient_id);
    List<Note> selectSelectedNotesOfPatient(int patient_id);
    Note selectNoteById(int id);
    int deleteNoteById(int id);
    int updateNoteById(int id, Note note);
}
