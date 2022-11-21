package com.proyecto.cineplus.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private double total;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "orden")
    public List<DetalleOrden> detalle;

    public Orden(Integer id, String numero, double total) {
        this.id = id;
        this.numero = numero;
        this.total = total;
    }
}
