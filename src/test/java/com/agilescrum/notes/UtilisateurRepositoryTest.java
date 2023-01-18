package com.agilescrum.notes;

import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.repositories.UtilisateursRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
public class UtilisateurRepositoryTest {
	@Autowired
	private UtilisateursRepository repository;
	
	@BeforeEach
	public void setup() {
		// initialisation de la base avant chaque test.
	}
	

}
