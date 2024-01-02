/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cod_venta;
    
    private LocalDate fecha_venta;
    private Double total;
    
    @ManyToMany
    private List <Producto> listaProductos;
    
    @OneToOne
    @JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long cod_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.cod_venta = cod_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    
    
}
