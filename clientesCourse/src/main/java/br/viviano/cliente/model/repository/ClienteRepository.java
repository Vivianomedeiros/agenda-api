package br.viviano.cliente.model.repository;

import br.viviano.cliente.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome = :nome")
    public List<Cliente> consultaPorNome(@Param("nome") String nome);
}
