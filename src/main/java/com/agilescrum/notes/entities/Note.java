package com.agilescrum.notes.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grade")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Note {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "fk_id_matiere", nullable = false)
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "fk_id_user", nullable = false)
    private Utilisateur utilisateur;

    @Override
    public boolean equals(Object n) {
        if (this == n) return true;
        if (n == null || Hibernate.getClass(this) != Hibernate.getClass(n)) return false;
        Note note = (Note) n;
        return id != null && Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
