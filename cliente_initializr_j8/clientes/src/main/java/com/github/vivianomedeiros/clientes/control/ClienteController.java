package com.github.vivianomedeiros.clientes.control;

import com.github.vivianomedeiros.clientes.model.entity.Cliente;
import com.github.vivianomedeiros.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        clienteRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar (@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(cliente.getCpf());
            clienteRepository.save(cliente);
            return Void.TYPE;
        });
    }

    @GetMapping("/lista-todos")
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping("{id}")
    public Cliente clientePorId(@PathVariable Integer id){
        return clienteRepository.findById(id).get();
    }

    @GetMapping("/lista-por-nome")
    public List<Cliente> listaPorNome(@RequestBody String nome){
        return clienteRepository.getClienteByNome(nome);
    }
}
