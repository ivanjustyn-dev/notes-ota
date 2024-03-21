package com.ivanaustria.notesota.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDto {
	
	private Integer id;
	private String title;
	private String content;
	private Date created_at;

}
