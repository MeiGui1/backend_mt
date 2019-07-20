package com.masterthesis.ConsApp.service;

import com.masterthesis.ConsApp.dao.NoteDao;
import com.masterthesis.ConsApp.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteService(@Qualifier("noteRepository") NoteDao noteDao) {
        this.noteDao = noteDao;
    }


    public int addNote(Note note) {
        return noteDao.insertNote(note);
    }

    public List<Note> getAllNotes() {
        return noteDao.selectAllNotes();
    }

    public List<Note> getNotesOfPatient(int patient_id) {
        return noteDao.selectAllNotesOfPatient(patient_id);
    }

    public List<Note> getSelectedNotesOfPatient(int patient_id) {
        return noteDao.selectSelectedNotesOfPatient(patient_id);
    }

    public Note getNoteById(int id) {
        return noteDao.selectNoteById(id);
    }

    public int deleteNote(int id) {
        return noteDao.deleteNoteById(id);
    }

    public int updateNote(int id, Note note) {
        return noteDao.updateNoteById(id, note);
    }
}
