package com.github.fi3te.spring.webflux.demo.repository;

import com.github.fi3te.spring.webflux.demo.entity.User;
import reactor.core.publisher.Flux;

public interface UserRepository {

    Flux<User> findAll();

}
