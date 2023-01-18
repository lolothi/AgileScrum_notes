package com.agilescrum.notes;

import com.agilescrum.notes.entities.Matiere;
import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.repositories.NoteRepository;
import com.agilescrum.notes.repositories.UtilisateursRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class NotesRepositoryTest {
	@Autowired
	private NoteRepository repository;
	
	@BeforeEach
	public void setup() {
		// initialisation de la base avant chaque test.
	}
	
	@Test
	public void shouldGetUserNotes() {
		for (Note note:repository.findAllUserGradeWithMatiere(3L)) {
			Assertions.assertEquals(note.getUtilisateur().getId(), 3L);
		}
	}
	
	@Test
	public void shouldGetMatieresNotes() {
		List<Matiere> matieres = new ArrayList();;
		for (Note note:repository.findAllUserGradeWithMatiere(3L)) {
			matieres.add(note.getMatiere());
		}
		Assertions.assertEquals(matieres.size(), 2);
	}
}
