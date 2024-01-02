/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.dto;

import lombok.Data;

@Data
public class BazarDTO {
    
    private Long codigo_venta;
    private double total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public BazarDTO() {
    }

    public BazarDTO(Long codigo_venta, double total, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
    
}
