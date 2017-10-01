package com.github.fi3te.spring.webflux.demo.rest;

import com.github.fi3te.spring.webflux.demo.dto.UserDTO;
import com.github.fi3te.spring.webflux.demo.repository.UserRepositoryStub;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepositoryStub userRepository;

    private final Mapper mapper;

    @Autowired
    public UserController(UserRepositoryStub userRepository) {
        this.userRepository = userRepository;
        this.mapper = new DozerBeanMapper();
    }

    @GetMapping
    public Flux<UserDTO> findAll() {
        return userRepository.findAll().map(user -> mapper.map(user, UserDTO.class));
    }

}
