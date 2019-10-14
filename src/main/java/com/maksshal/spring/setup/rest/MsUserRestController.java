package com.maksshal.spring.setup.rest;

import com.maksshal.spring.setup.db.entities.MsUser;
import com.maksshal.spring.setup.db.repositories.MsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MsUserRestController {

    @Autowired
    private MsUserRepository userRepository;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public MsUser getUser(String lastName) throws InterruptedException {
        return userRepository.findByLastName(lastName);
    }
}
