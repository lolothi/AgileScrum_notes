package com.agilescrum.notes.repositories;

import com.agilescrum.notes.entities.Note;
import com.agilescrum.notes.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateursRepository extends CrudRepository <Utilisateur, Long> {
    @Query("SELECT Concat(u.first_name, ' ',u.last_name) as Utilisateur, m.label as Matiere, g.Value as note, g.comment " +
            "as Commentaire  FROM user u INNER JOIN grade g On g.fk_id_user = u.id INNER JOIN matiere m ON m.id = g.fk_id_matiere" +
            " WHERE u.username = :username")
    List<Note> findAllGrade(@Param("username") String Nom_Utilisateur);

    @Query("SELECT Concat(u.first_name, ' ',u.last_name) as Utilisateur, m.label as Matiere, g.Value as note, g.comment " +
            "as Commentaire  FROM user u INNER JOIN grade g On g.fk_id_user = u.id INNER JOIN matiere m ON m.id = g.fk_id_matiere" +
            " WHERE u.username = :username And m.label = :matiere")
    List<Note> findAllGradeByMatiere(@Param("username") String Nom_Utilisateur, @Param("matiere") String Matiere);

    @Query("SELECT * FROM user u INNER JOIN grade g On g.fk_id_user = u.id INNER JOIN matiere m ON m.id = g.fk_id_matiere" +
            " WHERE u.username = :username AND u.password = :password")
    Utilisateur findUtilisateurConnecte(@Param("username") String Nom_Utilisateur, @Param("password") String Mot_De_Passe);
}