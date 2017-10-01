package com.github.fi3te.spring.webflux.demo;


import com.github.fi3te.spring.webflux.demo.dto.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ClientApp {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ClientApp.class, args);

        WebClient client = WebClient.builder()
            .baseUrl("http://localhost:9999")
            .build();

        Flux<UserDTO> users = client.get()
            .uri("/user")
            .accept(MediaType.APPLICATION_STREAM_JSON)
            .retrieve().bodyToFlux(UserDTO.class);

        users.subscribe(System.out::println, System.err::println, applicationContext::close);
    }
}
