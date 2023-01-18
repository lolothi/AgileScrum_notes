package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Matiere;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends CrudRepository<Matiere, Long> {

    //requête crud mise à jour du label d'une des matière via son id
    @Modifying
    @Query("Update Matiere m set m.label = :label WHERE m.id = :id")
    Long updateMatiereSetLabelById (@Param("id") Long id, @Param("label") String new_label);

    @Modifying
    @Query("DELETE from Matiere m  where m.id = :id")
    Long deleteMatiereById(@Param("id") Long id);

    @Modifying
    @Query("INSERT INTO Matiere (label) VALUES(:label)")
    String AddMatiere(@Param("label") String label);
}
