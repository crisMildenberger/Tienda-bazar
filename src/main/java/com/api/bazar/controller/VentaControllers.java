/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.controller;


import com.api.bazar.dto.BazarDTO;
import com.api.bazar.model.Producto;
import com.api.bazar.model.Venta;
import com.api.bazar.service.VentaService;
import java.time.LocalDate;
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
public class VentaControllers {
              
    @Autowired
    private VentaService venSer;
    
    
    //crear una venta
    @PostMapping("/ventas/crear")
    public String saveVentas(@RequestBody Venta ven){
        
        String stock=venSer.saveVenta(ven);
        
        if (stock.equals("stock")){
        return "Venta creada exitosamente";
                }else{
            return stock;
        }
    }
    
    //traer una lista de ventas
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        List<Venta>listaVentas = venSer.getVentas();
        return listaVentas;
    }
    
    //encontrar una venta mediante id
    @GetMapping("/ventas/{id_ventas}")
    public Venta findUnaVenta(@PathVariable Long id_venta){
        Venta ven=venSer.findVenta(id_venta);
        return ven;
    }
    
    //eliminar una venta mediante id
    @DeleteMapping("/ventas/eliminar/{id_venta}")
    public String deleteVenta(@PathVariable Long id_venta){
        venSer.deleteVenta(id_venta);
        return "Venta eliminada exitosamente";
    }
    
    //editar una venta mediante un objeto Venta
    @PutMapping ("/ventas/editar")
    public Venta editVenta(@RequestBody Venta ven){
        venSer.editVenta(ven);
        
        return venSer.findVenta(ven.getCod_venta());
    }
    
    //traer lista de productos de determinada venta por id
    @GetMapping ("/ventas/productos/{id_ventas}")
    public List<Producto> getListaProductos(@PathVariable Long id_ventas){
        List<Producto> listaProductos = venSer.getListaProductos(id_ventas);
        
        Venta ven = venSer.findVenta(id_ventas);
        
         System.out.println(ven);
         System.out.println("");
        
        return listaProductos;
    }
        
        //traer el monto y la cantidad vendida de determinado dia
        @GetMapping ("/ventas/fecha/{fecha}")
        public String getVentasFecha(@PathVariable LocalDate fecha){
            
            return venSer.getVentasFecha(fecha);
            
        }
        
        //Trae un objeto dto, con los atributos mas relevantes
        @GetMapping ("/ventas/dto")
        public BazarDTO getDto(){
            
            return venSer.getDTO();
        }
        
    }

