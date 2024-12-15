package com.nightlos.exp1.interceptor;

import com.nightlos.exp1.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.nightlos.exp1.dto.User;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int role = (int) request.getAttribute("role");
        if (role != User.admin) {
            throw new XException("无权限");
        }
        return true;
    }
}
