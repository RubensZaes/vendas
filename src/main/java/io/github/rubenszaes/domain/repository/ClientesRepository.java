package io.github.rubenszaes.domain.repository;
import io.github.rubenszaes.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

//    List<Cliente> findByNomeLike(String nome);

    @Query(value = " SELECT c FROM Cliente c WHERE c.nome LIKE :nome ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query( "DELETE FROM Cliente c WHERE c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
}
