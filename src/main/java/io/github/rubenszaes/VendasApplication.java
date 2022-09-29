package io.github.rubenszaes;

import io.github.rubenszaes.domain.entity.Cliente;
import io.github.rubenszaes.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepository){
        return args -> {
            System.out.println("Salvando Clientes");
            clientesRepository.save(new Cliente("Rubens"));
            clientesRepository.save(new Cliente("Stanley"));

            List<Cliente> result = clientesRepository.encontrarPorNome("Rubens");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
