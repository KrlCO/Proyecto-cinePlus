package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "butaca")
public class Butaca {

    @Id
    private String idbutaca;
    private int fila;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "idsala", insertable = false, updatable = false)
    private Sala sala;
    private int idsala;

}
