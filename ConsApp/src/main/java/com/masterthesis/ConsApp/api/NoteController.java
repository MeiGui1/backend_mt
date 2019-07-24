package com.masterthesis.ConsApp.api;

import com.masterthesis.ConsApp.model.Note;
import com.masterthesis.ConsApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


//Client uses these functions

@RequestMapping("/api/v1")
@RestController
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(path = "/note")
    public void addNote(@RequestBody Note note){
        noteService.addNote(note);
    }

    @GetMapping(path = "/note")
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }

    @GetMapping(path = "/note/patient_id={patient_id}")
    public List<Note> getNotesOfPatient(@PathVariable("patient_id") int patient_id){
        return noteService.getNotesOfPatient(patient_id);
    }

    @GetMapping(path = "/note/selected/patient_id={patient_id}")
    public List<Note> getSelectedNotesOfPatient(@PathVariable("patient_id") int patient_id){
        return noteService.getSelectedNotesOfPatient(patient_id);
    }

    @GetMapping(path = "/note/{id}")
    public Note getNoteById(@PathVariable("id") int id){
        return noteService.getNoteById(id);
    }

    @DeleteMapping(path = "/note/{id}")
    public void deleteNoteById(@PathVariable("id") int id){
        noteService.deleteNote(id);
    }

    @PutMapping(path = "/note/{id}")
    public void updateNote(@PathVariable("id") int id, @Valid @NotNull @RequestBody Note note){
        noteService.updateNote(id, note);
    }

    @GetMapping(path = "/note_last_id")
    public int getLastNoteId(){
        return noteService.getLastNoteId();
    }
}
