package com.agilescrum.notes;

import com.agilescrum.notes.entities.Matiere;
import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.repositories.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NotesApplicationTests {

	@Autowired
	private NoteRepository noteRepository;

	private Matiere matiere = null;



	@Test
	void shouldNotesInDB() {
		System.out.println("hello");
		List<Note> notes = (List<Note>) noteRepository.findAll();
		System.out.println(notes);

		//final List<Note> note1 = noteRepository.findByMatiereIdAndUtilisateurId(1L, 3L);
		//System.out.println(note1);


	}

}
