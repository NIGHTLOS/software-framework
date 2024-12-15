package com.nightlos.exp1.controller;

import com.nightlos.exp1.dto.User;
import com.nightlos.exp1.exception.XException;
import com.nightlos.exp1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User u, HttpServletResponse response) {
        log.debug("{}", u);
        User user = userService.getUser(u.getAccount(), u.getPassword());
        if (user == null) {
            throw new XException("用户名或密码错误");
        }
        response.addHeader("role", user.getRole().toString());
        response.addHeader("uid", user.getId().toString());
        return  Map.of("user", user);
    }
}
