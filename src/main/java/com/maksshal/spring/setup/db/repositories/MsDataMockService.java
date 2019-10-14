package com.maksshal.spring.setup.db.repositories;

import com.maksshal.spring.setup.db.entities.MsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("test")
public class MsDataMockService {

    @Autowired
    private MsUserRepository userRepository;

    @PostConstruct
    private void initData() {
        MsUser user = new MsUser();
        user.setFirstName("Maksym");
        user.setLastName("Shalak");
        userRepository.save(user);
    }
}
