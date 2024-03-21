package com.ivanaustria.notesota.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "notes")
public class Note {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String title;
	private String content;
	@CreatedDate
	Date created_at;
	
	@PrePersist
	void preCreate() {
		created_at = new Date();
	}
	
	public Note updateWith(Note note) {
		this.setTitle(note.getTitle());
		this.setContent(note.getContent());
		return this;
	}

}
