package com.dim.Module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "padrones")
public class Padrones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_padrones;

    private boolean modificado;

    private Integer padron;

    private String svg;

    private Long deuda;

    // La relación muchos a uno con Deuda
//    @ManyToOne
//    @JoinColumn(name = "deuda_id")
//    private Deuda deuda;

}
