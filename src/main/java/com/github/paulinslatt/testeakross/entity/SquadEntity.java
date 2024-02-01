package com.github.paulinslatt.testeakross.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_squad")
public class SquadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "squad", cascade = {CascadeType.ALL})
    private List<ColaboradorEntity> colaboradores = new ArrayList<>();

}
