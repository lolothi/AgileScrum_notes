package com.agilescrum.notes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @JoinTable(name = "type_user",
            joinColumns= @JoinColumn(name = "id" ),
            inverseJoinColumns= @JoinColumn( name = "id"))
    private List<TypeUtilisateur> typeUtilisateurList;

    @ManyToOne
    @JoinTable(name = "formation",
            joinColumns= @JoinColumn(name = "id" ),
            inverseJoinColumns= @JoinColumn( name = "id"))
    private List<Formation> formationList;
}
