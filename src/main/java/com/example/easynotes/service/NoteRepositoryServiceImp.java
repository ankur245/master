package com.example.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.exception.*;

@Service
public class NoteRepositoryServiceImp implements NoteRepositoryService {

	
	@Autowired
    NoteRepository noteRepository;
	
	
	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public Note save(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public Note findById(Long noteId) throws ResourceNotFoundException{
		return noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	@Override
	public Note updateNote(Long noteId, Note noteDetails) throws ResourceNotFoundException{
		
		Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        
        return note;
	}

	@Override
	public ResponseEntity<Long> deleteNote(Long noteId) throws ResourceNotFoundException{
		Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();	
	}

}
