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

@Entity
@Data
public class Cliente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id_cliente;
    
    private String nombre;
    private String apellido;
    private long dni;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, long dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    
    
}
