package io.github.rubenszaes.domain.repository;

import io.github.rubenszaes.domain.entity.Cliente;
import io.github.rubenszaes.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Set<Pedido> findByCliente(Cliente cliente);
}
