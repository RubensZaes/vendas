package io.github.rubenszaes.domain.repository;

import io.github.rubenszaes.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
