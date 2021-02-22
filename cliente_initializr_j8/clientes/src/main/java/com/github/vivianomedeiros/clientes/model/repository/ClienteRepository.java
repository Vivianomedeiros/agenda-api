package com.github.vivianomedeiros.clientes.model.repository;

import com.github.vivianomedeiros.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.nome = :nomeConsulta")
    public List<Cliente> getClienteByNome(@Param("nomeConsulta") String nomeConsulta);
}
