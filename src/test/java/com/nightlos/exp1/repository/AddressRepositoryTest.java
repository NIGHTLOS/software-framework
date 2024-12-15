package com.nightlos.exp1.repository;

import com.nightlos.exp1.dto.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void addAddressTest(){
        Address address = Address.builder()
                .detail("nefu")
                .userId(4)
                .build();
        addressRepository.save(address);
    }
}