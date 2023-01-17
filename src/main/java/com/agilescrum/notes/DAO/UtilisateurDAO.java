package com.agilescrum.notes.DAO;

import org.springframework.stereotype.Repository;

import com.agilescrum.notes.entities.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class UtilisateurDAO {

    @PersistenceContext
    EntityManager em;

    /**
     * Enregistre un utilisateur dans la base de donnée
     * 
     * @param utilisateur
     */

    public void save(Utilisateur utilisateur) {
        em.persist(utilisateur);
    }

    /**
     * Récupération d'un utilisateur à partir de son identifiant
     * 
     * @param id
     * @return
     */
    public Utilisateur getByID(Long id) {
        return em.find(Utilisateur.class, id);
    }

    /**
     * suppression d'un utilisateur de la base de données à partir de son
     * identifiant
     * 
     * @param id
     */
    public void delete(long id) {
        Query query = em.createQuery("delete from Utilisateur o  where o.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}