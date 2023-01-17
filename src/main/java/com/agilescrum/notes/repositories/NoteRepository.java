package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Integer, Note> {
}
