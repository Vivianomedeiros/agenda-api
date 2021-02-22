package com.github.viviano.agendaapi.control;

import com.github.viviano.agendaapi.model.entity.Contato;
import com.github.viviano.agendaapi.model.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody Contato contato){
        return contatoRepository.save(contato);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        contatoRepository.deleteById(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contato consultarId(@PathVariable Integer id){
        return contatoRepository.findById(id).get();
    }

    @GetMapping("/todos-contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listaTodos(){
        return contatoRepository.findAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void atualizar(@PathVariable Integer id, @RequestBody Contato contatoAtualizado){
        contatoAtualizado.setId(contatoRepository.findById(id).get().getId());
        contatoRepository.save(contatoAtualizado);
    }

    @GetMapping("/consulta-nome")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Contato> consultarNome(@RequestBody String nome){
        return contatoRepository.consultaNome(nome);
    }
}
