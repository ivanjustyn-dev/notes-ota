package com.ivanaustria.notesota.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ivanaustria.notesota.entity.Note;
import com.ivanaustria.notesota.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {
	
	private final NoteRepository noteRepository;
	
	public List<Note> getAll(){
		return noteRepository.findAll();
	}
	
	public Optional<Note> get(Integer id){
		return noteRepository.findById(id);
	}
	
	public Note save(Note note) {
		return noteRepository.save(note);
	}
	
	public void delete(Note note) {
		noteRepository.delete(note);
	}

}
