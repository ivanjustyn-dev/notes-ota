package com.ivanaustria.notesota.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivanaustria.notesota.dto.NoteDto;
import com.ivanaustria.notesota.entity.Note;
import com.ivanaustria.notesota.mapper.NoteMapper;
import com.ivanaustria.notesota.repository.NoteRepository;
import com.ivanaustria.notesota.service.NoteService;


import com.ivanaustria.notesota.exceptions.ApplicationException;
import com.ivanaustria.notesota.exceptions.NotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("notes")
public class NotesController {
	
	private final NoteService noteService;
	private final NoteMapper noteMapper;
	
	@GetMapping
	public ResponseEntity<List<NoteDto>> getAll(){
		List<NoteDto> notes = noteService
				.getAll()
				.stream()
				.map(noteMapper::asNoteDto)
				.collect(Collectors.toList());
		return new ResponseEntity<List<NoteDto>>(notes, HttpStatus.OK);
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoteDto> get(@PathVariable int id){
		return noteService
				.get(id)
				.map(noteMapper::asNoteDto)
				.map(ResponseEntity::ok)
				.orElseThrow(NotFoundException::new);
	}
	
	@PostMapping
	public ResponseEntity<NoteDto> create(@RequestBody NoteDto noteDto){
		return Optional
				.ofNullable(noteDto)
				.map(noteMapper::asNote)
				.map(noteService::save)
				.map(noteMapper::asNoteDto)
				.map(ResponseEntity::ok)
				.orElseThrow(ApplicationException::new);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NoteDto> update(@PathVariable int id, @RequestBody NoteDto noteDto) {
		return noteService
			.get(id)
			.map( oldNote -> oldNote.updateWith(noteMapper.asNote(noteDto)))
			.map(noteService::save)
			.map(noteMapper::asNoteDto)
			.map(ResponseEntity::ok)
			.orElseThrow(NotFoundException::new);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return noteService
				.get(id)
				.map(note -> {
					noteService.delete(note);
					return ResponseEntity.noContent().build();
				})
				.orElseThrow(NotFoundException::new);
		
	}

}
