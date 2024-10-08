package com.Backend.Entities;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patrollings")
@Getter
@Setter
public class Patrolling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    private Police head;

    // add the timeline and details

    private Date date;

    @OneToMany(mappedBy = "patrolling", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubPatrolling> subPatrollings;
    

}
