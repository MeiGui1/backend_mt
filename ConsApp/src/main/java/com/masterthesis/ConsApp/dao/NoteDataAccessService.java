package com.masterthesis.ConsApp.dao;

import com.masterthesis.ConsApp.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("noteRepository")
public class NoteDataAccessService implements NoteDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NoteDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertNote(Note note) {
        final String sql = "INSERT INTO Note (patient_id, note_bytes, selected) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                note.getPatient_id(), note.getNote_bytes(), note.isSelected()
        );    }

    @Override
    public List<Note> selectAllNotes() {
        final String sql = "SELECT * FROM Note ORDER BY patient_id";
        List<Note> allNotes = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            int patient_id = resultSet.getInt("patient_id");
            byte[] note_bytes = resultSet.getBytes("note_bytes");
            boolean selected = resultSet.getBoolean("selected");
            return new Note(id, patient_id, note_bytes, selected);
        });
        return allNotes;
    }

    @Override
    public List<Note> selectAllNotesOfPatient(int patient_id) {
        final String sql = "SELECT * FROM Note WHERE patient_id = "+ patient_id + " ORDER BY id";
        List<Note> allNotesOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            byte[] note_bytes = resultSet.getBytes("note_bytes");
            boolean selected = resultSet.getBoolean("selected");
            return new Note(id, patient_id, note_bytes, selected);
        });
        return allNotesOfPatient;
    }

    @Override
    public List<Note> selectSelectedNotesOfPatient(int patient_id) {
        final String sql = "SELECT * FROM Note WHERE selected AND patient_id = "+ patient_id + " ORDER BY id";
        List<Note> allSelectedNotesOfPatient = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            byte[] note_bytes = resultSet.getBytes("note_bytes");
            boolean selected = resultSet.getBoolean("selected");
            return new Note(id, patient_id, note_bytes, selected);
        });
        return allSelectedNotesOfPatient;
    }

    @Override
    public Note selectNoteById(int id) {
        String sql = "SELECT * FROM Note WHERE id = ?";
        return (Note) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new RowMapper<Note>() {
                    @Override
                    public Note mapRow(ResultSet rs, int rowNumber) throws SQLException {
                        Note selectedNote = new Note(id,
                                rs.getInt("patient_id"),
                                rs.getBytes("note_bytes"),
                                rs.getBoolean("selected"));
                        return selectedNote;
                    }
                });    }

    @Override
    public int deleteNoteById(int id) {
        String sql = "DELETE FROM Note WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateNoteById(int id, Note note) {
        String sql = "UPDATE Note SET selected = ? WHERE id = ?";
        return jdbcTemplate.update(sql, note.isSelected(), id);
    }
}
