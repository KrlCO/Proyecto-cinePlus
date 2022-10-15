package com.proyecto.cineplus.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reservacion")
public class Reservacion {

    @Id
    private String idreservacion;

    @ManyToOne
    @JoinColumn(name="idpeli", insertable = false, updatable = false)
    private Pelicula pelicula;
    private String idpeli;

    @ManyToOne
    @JoinColumn(name="idcliente", insertable = false, updatable = false)
    private Cliente cliente;
    private String idcliente;

    @ManyToOne
    @JoinColumn(name = "idreserva", insertable = false, updatable = false)
    private Tiporeservacion tiporeservacion;
    private int idreserva;

    private String contactoreserva;
    private boolean reserva;
    private boolean pago;
    private String estado;

}
