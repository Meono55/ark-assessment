package com.ark.arkassessment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Fund> funds;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Investor> investors;
}
