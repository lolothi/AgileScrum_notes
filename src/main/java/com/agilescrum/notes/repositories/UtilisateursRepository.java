package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursRepository extends CrudRepository <Utilisateur, Long> {
    @Query("SELECT Concat(u.first_name, ' ',u.last_name) as Utilisateur, m.label as Matiere, g.Value as note, g.comment " +
            "as Commentaire  FROM user u INNER JOIN grade g On g.fk_id_user = u.id INNER JOIN matiere m ON m.id = g.fk_id_matiere" +
            " WHERE u.username = :username")
    List<Grade> findAllGrade(@Param("username") String Nom_Utilisateur);

    @Query("SELECT Concat(u.first_name, ' ',u.last_name) as Utilisateur, m.label as Matiere, g.Value as note, g.comment " +
            "as Commentaire  FROM user u INNER JOIN grade g On g.fk_id_user = u.id INNER JOIN matiere m ON m.id = g.fk_id_matiere" +
            " WHERE u.username = :username And m.label = :matiere")
    List<Grade> findAllGradeByMatiere(@Param("username") String Nom_Utilisateur, @Param("matiere") String Matiere);
}
