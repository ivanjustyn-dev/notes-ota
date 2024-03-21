package com.ivanaustria.notesota.mapper;

import org.mapstruct.Mapper;

import com.ivanaustria.notesota.dto.NoteDto;
import com.ivanaustria.notesota.entity.Note;

@Mapper(componentModel = "spring", config = GlobalMapperConfig.class)
public interface NoteMapper {
	Note asNote(NoteDto noteDto);
	NoteDto asNoteDto(Note note);
}
