package com.github.viviano.agendaapi.model.repository;

import com.github.viviano.agendaapi.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    @Query("SELECT c FROM Contato c") // WHERE c);//.nome = :nomeConsulta")
    public List<Contato> consultaNome(@Param("nomeConsulta") String nomeConsulta);
}
