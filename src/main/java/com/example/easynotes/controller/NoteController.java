package com.example.easynotes.controller;

import com.example.easynotes.model.Note;
//import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.service.NoteRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepositoryService noteRepositoryService;

    // Get All Notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepositoryService.findAll();
    }
    
    // Create a new Note with request body
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepositoryService.save(note);
    }

    // Get a Single Note
    // a new comment added
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
    	Note n=  noteRepositoryService.findById(noteId);
        return n;
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                            @Valid @RequestBody Note noteDetails) {

        return noteRepositoryService.updateNote(noteId, noteDetails);
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Long> deleteNote(@PathVariable(value = "id") Long noteId) {
        return noteRepositoryService.deleteNote(noteId);
    }
}