package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sala")
public class Sala {

    @Id
    private int idsala;
    private String nombre;
    private String nrobutacas;
}
