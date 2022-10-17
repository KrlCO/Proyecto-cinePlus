package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tiporeservacion")
public class Tiporeservacion {

    @Id
    private int idreserva;

    private String descripcion;

}
