package io.github.rubenszaes.domain.repository;

import io.github.rubenszaes.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
}
