/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.service;

import com.api.bazar.model.Cliente;
import com.api.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository icr;
    
    @Override
    public void saveCliente(Cliente cli) {
        icr.save(cli);
    }

    @Override
    public List<Cliente> getClientes() {
    List<Cliente>listaCliente= icr.findAll();
            return listaCliente;
    }

    @Override
    public void deleteCliente(Long id) {
        icr.deleteById(id);
    }

    

    @Override
    public Cliente findCliente(Long id) {
    
    Cliente cli=icr.findById(id).orElse(null);
    
    return cli;
    }

    @Override
    public void editCliente(Cliente cli) {
    icr.save(cli);
    }
    
}
