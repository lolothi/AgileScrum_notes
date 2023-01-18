package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Matiere;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends CrudRepository<Matiere, Long> {

}
