/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.model.Producto;
import com.api.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository ipr;

    @Override
    public void saveProducto(Producto pro) {
       ipr.save(pro);
    }

    @Override
    public List<Producto> getProductos() {
      List<Producto> listaProductos= ipr.findAll();
        return listaProductos;
    }

    @Override
    public void deleteProducto(Long id) {
       ipr.deleteById(id);
    }

    @Override
    public void editProducto(Producto pro) {
     ipr.save(pro);
    }

    @Override
    public Producto findProducto(Long id) {
      Producto pro=ipr.findById(id).orElse(null);
        return pro;
    }

    @Override
    public List<Producto> underFiveProductos() {
    
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaProductos2= new ArrayList();
        for(Producto aux:listaProductos){
            
            if(5 >=aux.getCant_disp()){
                
                listaProductos2.add(aux);
            }
            
        }
        
    return listaProductos2;
    }

    @Override
    public String abateProductos(List<Producto> listaProductos) {
   
   
     List<Producto> listaProcutosCompleta=this.getProductos();
     
     for (Producto aux:listaProductos){
         
      for(Producto aux2:listaProcutosCompleta){
     
          if(aux.getId_producto().equals(aux2.getId_producto())){
            int cantDisp=aux2.getCant_disp();
              if(cantDisp<=0){
                  String pro=aux2.getNombre();
              return"NO HAY STOCK DE: " + pro.toUpperCase() ;
                  }  else {
              aux2.setCant_disp(aux2.getCant_disp() -1);
                  } 
          
     }
         
     }
      
}
      return "stock";
    }
}
