/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
       public void saveCliente(Cliente cli);
    
       public List<Cliente> getClientes();
    
       public void deleteCliente(Long id);
    
       public void editCliente(Cliente cli);
    
       public Cliente findCliente(Long id);
    
}
