package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "butacareserva")
public class Butacareserva {

    @Id
    private String idresbutaca;

    @ManyToOne
    @JoinColumn(name = "idbutaca", insertable=false, updatable = false)
    private Butaca butaca;
    private String idbutaca;

    @ManyToOne
    @JoinColumn(name = "idreservacion", insertable = false, updatable = false)
    private Reservacion reservacion;
    private String idreservacion;

}
