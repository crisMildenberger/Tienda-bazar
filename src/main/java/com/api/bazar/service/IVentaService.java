/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.dto.BazarDTO;
import com.api.bazar.model.Producto;
import com.api.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public String saveVenta(Venta ven);
    
    public List<Venta> getVentas();
    
    public void deleteVenta(Long id);
    
    public void editVenta(Venta ven);
    
    public Venta findVenta(Long id);
    
    public List<Producto> getListaProductos(Long id);
    
    public String getVentasFecha(LocalDate fecha);
    
    public Venta findMaxVenta();
    
    public BazarDTO getDTO();
    
    public int sumProductos(Venta ven);
    
    public double getTo(Venta ven);
    
    
    
}
