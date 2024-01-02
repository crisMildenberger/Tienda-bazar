/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.bazar.controller;

import com.api.bazar.model.Cliente;
import com.api.bazar.service.ClienteService;
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
public class ClienteControllers {
      
    @Autowired
    private ClienteService cliSer;
    
    //crear clientes
    @PostMapping("/clientes/crear")
    public String saveClientes(@RequestBody Cliente cli){
        cliSer.saveCliente(cli);
        return "Cliente creado exitosamente";
    }
    
    //traer una lista de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente>listaClientes = cliSer.getClientes();
        return listaClientes;
    }
    
    //encontrar un cliente por id
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findUnCliente(@PathVariable Long id_cliente){
        Cliente cli=cliSer.findCliente(id_cliente);
        return cli;
    }
    
    //eliminar un cliente por id
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliSer.deleteCliente(id_cliente);
        return "Cliente eliminado exitosamente";
    }
    
    //editar un cliente mediante un objeto Cliente
    @PutMapping ("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente cli){
        cliSer.editCliente(cli);

        return cliSer.findCliente(cli.getId_cliente());
    }
}
