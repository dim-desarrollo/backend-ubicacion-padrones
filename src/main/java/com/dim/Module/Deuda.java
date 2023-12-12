package com.dim.Module;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeuda;

    private String tipoDeuda;
    private String color;

    // La relación uno a muchos con Padron
//    @OneToMany(mappedBy = "deuda")
//    private List<Padrones> padrones;

    // Getters y setters
}