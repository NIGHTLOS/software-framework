package com.nightlos.exp1.repository;


import com.nightlos.exp1.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.nightlos.exp1.dto.User.admin;

@Slf4j
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User u= User.builder()
                .account("2022212867")
                .password("123456")
                .role(admin)
                .build();
        userRepository.save(u);
    }

    @Test
    public void findUserByIdTest() {
        userRepository.findById(1).ifPresent(u->log.debug(u.getAccount()));
    }

    @Test
    public void findByAid(){
        userRepository.find(1).ifPresent(u->log.debug("{}",u));
    }
}
