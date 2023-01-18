package com.agilescrum.notes;

import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.entities.Utilisateur;
import com.agilescrum.notes.repositories.NoteRepository;
import com.agilescrum.notes.repositories.UtilisateursRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
public class UtilisateurApplicationTests {
    @Autowired
    private UtilisateursRepository utilisateurRepository;

    @Test
    void shouldUserInDB() {
        //Scanner reader = new Scanner(System.in);  // Reading from System.in
        //System.out.println("Username : ");
        //String u = reader.nextLine();
        //System.out.println("Password : ");
        //String p = reader.nextLine();

        String u = "MDutoo";
        String p = "0000";

        Utilisateur utilisateur = utilisateurRepository.findUtilisateurConnecte(u, p);

        if (utilisateur != null){
            System.out.println("L'utilisateur connecté est : " + utilisateurRepository.findById(utilisateur.getId()));
        } else {
            System.out.println("Cette utilisateur n'existe pas");
        }

        //once finished
        //reader.close();

    }
}
