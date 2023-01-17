package com.agilescrum.notes.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Utilisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "first_name")
        private String lastName;

        @Column(name = "last_name")
        private String firstName;

        @Column(name = "username")
        private String username;

        @Column(name = "password")
        private String password;

        @ManyToOne
        @JoinColumn(name = "fk_id_type_user", nullable = false)
        private TypeUtilisateur typeUtilisateur;

        @ManyToOne
        @JoinColumn(name = "fk_id_formation", nullable = false)
        private Formation formation;
}
