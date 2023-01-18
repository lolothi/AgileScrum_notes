package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Note;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
    @Transactional
    @Modifying
    @Query("update Note n set n.value = :newNoteValue where n.id = :noteId")
    void findNoteByIdAndUpdate(@NonNull @Param("newNoteValue") Integer newNoteValue, @NonNull @Param("noteId") Integer noteId);

    @Query(value= "SELECT n FROM Note n where n.matiere.id  =:matiereId AND n.utilisateur.id  =:utilisateurId ORDER BY n.matiere.label asc ")
    List<Note> findNoteByMatiereIdAndUtilisateurId(@Param("matiereId")Long matiereId, @Param("utilisateurId")Long utilisateurId);
}
