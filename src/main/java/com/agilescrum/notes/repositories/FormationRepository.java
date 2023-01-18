package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Formation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FormationRepository extends CrudRepository<Formation, Long> {
	@Transactional
	@Modifying
	@Query("update Formation f set f.label = :newFormationValue where f.id = :formationId")
	void findByIdAndUpdate(@NonNull @Param("newFormationValue") String newFormationValue,
			@NonNull @Param("formationId") Long formationId);
}
