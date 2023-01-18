package com.agilescrum.notes;

import com.agilescrum.notes.entities.Matiere;
import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.repositories.NoteRepository;
import com.agilescrum.notes.repositories.UtilisateursRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NotesRepositoryTests {

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private UtilisateursRepository utilisateursRepository;

	private Matiere matiere = null;


	@Test
	void shouldSeeNotesInDB() {
		//Pour vérifier l'accès aux notes de la DB
		List<Note> notes = (List<Note>) noteRepository.findAll();
		System.out.println(notes);

		final List<Note> note1 = noteRepository.findNoteByMatiereIdAndUtilisateurId(1L, 3L);
		note1.forEach(note -> {
			System.out.println("Elève : " + utilisateursRepository.findById(note.getUtilisateur().getId()) + ", note : " + note.getValue());
		});
	}

	@Test
	public void shouldGetUserNotes() {
		for (Note note:noteRepository.findAllUserGradeWithMatiere(3L)) {
			Assertions.assertEquals(note.getUtilisateur().getId(), 3L);
		}
	}

	@Test
	public void shouldGetMatieresNotes() {
		List<Matiere> matieres = new ArrayList();;
		for (Note note:noteRepository.findAllUserGradeWithMatiere(3L)) {
			matieres.add(note.getMatiere());
		}
		Assertions.assertEquals(matieres.size(), 2);
	}

	@Test
	void shouldUpdateNote() {
		final Integer newNote = 16;

		noteRepository.findNoteByIdAndUpdate(newNote, 1);
		List<Note> note2 = noteRepository.findNoteByMatiereIdAndUtilisateurId(1L, 3L);
		note2.forEach(note -> {
			//System.out.println("Elève : " + utilisateursRepository.findById(note.getUtilisateur().getId()) + ", note = " + note.getValue());
			Assertions.assertEquals(note.getValue(), newNote);
		});

	}

}
