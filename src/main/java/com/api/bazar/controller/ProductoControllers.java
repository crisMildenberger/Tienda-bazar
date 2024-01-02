/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.controller;

import com.api.bazar.model.Producto;
import com.api.bazar.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoControllers {
    
    @Autowired
    private ProductoService proSer;
    
    //crear un producto
    @PostMapping("/productos/crear")
    public String saveProductos(@RequestBody Producto pro){
        proSer.saveProducto(pro);
        return "Producto creado exitosamente";
    }
    
    //traer una lista de productos
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        List<Producto>listaProductos = proSer.getProductos();
        return listaProductos;
    }
    
    //encontrar un producto mediante un id
    @GetMapping("/productos/{id_producto}")
    public Producto findUnProducto(@PathVariable Long id_producto){
        Producto pro=proSer.findProducto(id_producto);
        return pro;
    }
    
    //eliminar un producto mediante un id
    @DeleteMapping("/productos/eliminar/{id_producto}")
    public String deleteProducto(@PathVariable Long id_producto){
        proSer.deleteProducto(id_producto);
        return "Producto eliminado exitosamente";
    }
    
    //editar un producto mediante un objeto Producto
    @PutMapping ("/productos/editar")
    public Producto editProducto(@RequestBody Producto pro){
        proSer.editProducto(pro);
            return proSer.findProducto(pro.getId_producto());
    }
    
    //traer una lista de productos que cant_disp sea igual o menor a 5
    @GetMapping("/productos/falta_stock")
    public List<Producto> underFiveProductos(){
        List<Producto> listaProductos = proSer.underFiveProductos();
        return listaProductos;
    }
}
