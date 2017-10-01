package com.github.fi3te.spring.webflux.demo.repository;

import com.github.fi3te.spring.webflux.demo.entity.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepositoryStub implements UserRepository {

    private List<User> users = Collections.synchronizedList(new ArrayList<>());

    @PostConstruct
    public void init() {
        users.add(new User(455126, "Fiete"));
        users.add(new User(816179426, "Lara"));
        users.add(new User(11996153, "Peter"));
    }

    @Override
    public Flux<User> findAll() {
        return Flux.create(emitter -> {
            try {
                for (User user : users) {
                    emitter.next(user);
                    Thread.sleep(1000);
                }
                emitter.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
