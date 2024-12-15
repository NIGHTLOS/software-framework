package com.nightlos.exp1.service;

import com.nightlos.exp1.dto.Address;
import com.nightlos.exp1.dto.User;
import com.nightlos.exp1.repository.AddressRepository;
import com.nightlos.exp1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public User getUser(String account, String password) {
        return userRepository.find(account, password);
    }

    public User getUser(int uid) {
        return userRepository.findById(uid).orElse(null);
    }

    public List<Address> listAddresses(int uid) {
        return addressRepository.findAddresses(uid);
    }

}
