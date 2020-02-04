package com.example.easynotes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;


public interface NoteRepositoryService {

	public List<Note> findAll();
	
	public Note save(Note note);
	
	public Note findById(Long noteId) throws ResourceNotFoundException;
	
	public Note updateNote(Long noteId, Note noteDetails) throws ResourceNotFoundException;
	
	public ResponseEntity<Long> deleteNote(Long noteId) throws ResourceNotFoundException;
}
