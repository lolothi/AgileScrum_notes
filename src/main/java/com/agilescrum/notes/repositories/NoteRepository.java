package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Matiere;
import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.entities.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    @Transactional
    @Modifying
    @Query("update Note n set n.value = :newNoteValue where n.id = :noteId")
    void findByIdAndUpdate(@NonNull @Param("newNoteValue") Float newNoteValue, @NonNull @Param("noteId") Integer noteId);

    @Query(value= "SELECT n FROM Note n where n.matiere.id  =:matiereId AND n.utilisateur.id  =:utilisateurId ORDER BY n.matiere.label asc ")
    List<Note> findByMatiereIdAndUtilisateurId(@Param("matiereId")Integer matiereId, @Param("utilisateurId")Integer utilisateurId);
}
