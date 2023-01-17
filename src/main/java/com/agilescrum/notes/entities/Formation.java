package com.agilescrum.notes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "formation")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label")
    private String label;

    @ManyToOne
    @JoinTable(name = "matiere",
            joinColumns= @JoinColumn(name = "id" ),
            inverseJoinColumns= @JoinColumn( name = "id"))
    private List<Matiere> matiereList;
}
