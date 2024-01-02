/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_producto;
    
    private String nombre;
    private String marca;
    private double costo;
    private int cant_disp;
    
   

    public Producto() {
    }

    public Producto(Long id_producto, String nombre, String marca, double costo, int cant_disp) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_disp = cant_disp;
    }

 
    
    
}
