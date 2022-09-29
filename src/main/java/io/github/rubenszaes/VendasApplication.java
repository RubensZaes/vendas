package io.github.rubenszaes;

import io.github.rubenszaes.domain.entity.Cliente;
import io.github.rubenszaes.domain.entity.Pedido;
import io.github.rubenszaes.domain.repository.ClientesRepository;
import io.github.rubenszaes.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository, @Autowired PedidoRepository pedidoRepository){
        return args -> {
            System.out.println("Salvando Clientes");
            Cliente rubens = new Cliente("Rubens");
            clientesRepository.save(rubens);

            Pedido p = new Pedido();
            p.setCliente(rubens);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidoRepository.save(p);

//            Cliente cliente = clientesRepository.findClienteFetchPedidos(rubens.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidoRepository.findByCliente(rubens).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
