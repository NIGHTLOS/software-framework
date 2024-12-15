package com.nightlos.exp1.controller;


import com.nightlos.exp1.dto.Address;
import com.nightlos.exp1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;


    @GetMapping("addresses")
    public Map<String, Object> getUser(@RequestAttribute int uid) {
        List<Address> addresses = userService.listAddresses(uid);
        return Map.of("addresses", addresses);
    }
}
