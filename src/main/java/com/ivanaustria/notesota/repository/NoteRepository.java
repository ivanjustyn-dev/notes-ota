package com.ivanaustria.notesota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivanaustria.notesota.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

}
