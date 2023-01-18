package com.agilescrum.notes;
import com.agilescrum.notes.entities.Matiere;
import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.repositories.MatiereRepository;
import com.agilescrum.notes.repositories.NoteRepository;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MatiereRepositoryTests {

    @Autowired
    private MatiereRepository repository;

    @Test
    void updateMatiereSetLabelByIdTest(){
        System.out.println(repository.findAll());

        Matiere mat = new Matiere();
        mat.setId(1L);
        mat.setLabel("Test");
        repository.save(mat);
        System.out.println(repository.findAll());
    }

    @Test
    void deleteMatiereByIdTest(){
        System.out.println(repository.findAll());

        repository.deleteById(1L);
        System.out.println(repository.findAll());
    }
}
