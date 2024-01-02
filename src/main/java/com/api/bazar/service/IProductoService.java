/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto pro);
    
    public List<Producto> getProductos();
    
    public void deleteProducto(Long id);
    
    public void editProducto(Producto pro);
    
    public Producto findProducto(Long id);
    
    public List<Producto> underFiveProductos();
    
    public String abateProductos(List<Producto> listaProductos);
    
    
}
