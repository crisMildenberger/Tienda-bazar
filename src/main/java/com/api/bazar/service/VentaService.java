/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.dto.BazarDTO;
import com.api.bazar.model.Producto;
import com.api.bazar.model.Venta;
import com.api.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ivr;
    
    @Autowired
    private ProductoService proSer;
    
    @Override
    public String saveVenta(Venta ven) {
        
    List<Producto> listaProducto= ven.getListaProductos();
   
    
    //Envia una lista y recibe una cadena con la informacion de si hay o no STOCK
    String stock=proSer.abateProductos(listaProducto);
       
    
    //Saca el costo Total de la venta
     double costo= this.getTo(ven);
    
     ven.setTotal(costo);
     ivr.save(ven);
     
     return stock;
    }

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ivr.findAll();
            return listaVentas;
    }

    @Override
    public void deleteVenta(Long id) {
        ivr.deleteById(id);
    }

    @Override
    public void editVenta(Venta ven) {
        
    ivr.save(ven);
    }

    @Override
    public Venta findVenta(Long id) {
    Venta ven = ivr.findById(id).orElse(null);
        return ven;
    }

    @Override
    public List<Producto> getListaProductos(Long id) {
    
        Venta ven = this.findVenta(id);
        
        List<Producto> listaProductos = ven.getListaProductos();
    
        return listaProductos;
    
    }

    @Override
    public String getVentasFecha(LocalDate fecha) {
        List<Venta> listaVenta =this.getVentas();
        
        double monto=0;
        int cantidad=0;
        
        for(Venta aux:listaVenta){
            
            if(fecha.equals(aux.getFecha_venta())){
                
                monto= monto + aux.getTotal();
                cantidad= cantidad+1;
                
            }
            
        }
        
        return "Fecha: "+ fecha + " Monto total: " + monto + " Total:" +cantidad;
    
    }

    @Override
    public BazarDTO getDTO() {
        
     BazarDTO bazdto = new BazarDTO();
     Venta venMax= this.findMaxVenta();
     
     
     bazdto.setCodigo_venta(venMax.getCod_venta());
     bazdto.setCantidad_productos(this.sumProductos(venMax));
     bazdto.setTotal(venMax.getTotal());
     bazdto.setApellido_cliente(venMax.getUnCliente().getApellido());
     bazdto.setNombre_cliente(venMax.getUnCliente().getNombre());
     
     
     return bazdto;
     
    }

    @Override
    //Buscamos la venta de maximo valor
    public Venta findMaxVenta() {
        
      
        List <Venta> listaVentas= this.getVentas();
        List <Venta> listaIguales= new ArrayList();
          
        Venta ventaMax= new Venta();
        
        
        double montoMax=0;
        int i=0;
        
        for(Venta aux:listaVentas){
            
            if(aux.getTotal()>montoMax){
                
                montoMax= aux.getTotal();
                ventaMax= aux;
            }
            
        }
        
        //En caso de que haya mas de una venta con el maximo valor
        for(Venta aux:listaVentas){
            
            if(montoMax==aux.getTotal()){
                
                listaIguales.add(aux);
                
                i=i+1;
            }
            
        }
        
        System.out.println("Hay "+i+" valores maximos iguales, con el valor de: "+ventaMax);
        for(Venta aux:listaIguales){
            System.out.println(aux);
        }
        
        return ventaMax;
    
    }

    @Override
    //Conseguimos el total de cantidad de productos
    public int sumProductos(Venta ven) {
    
        List<Producto> listaProductos= ven.getListaProductos();
    
        int i=0;
        
        for(Producto aux:listaProductos){
            i=i+1;
        }
        
        return i;
    }

    @Override
//    Conseguimos el monto total de los productos
    public double getTo(Venta ven) {
        
        
    List<Producto> listaPro=ven.getListaProductos();
    
    double total=2.5;
    
    
    for(Producto aux:listaPro){
      total+= aux.getCosto();
       }
        
    return total;
              
   }
     

    
        
}
