package com.nightlos.exp1.interceptor;

import com.nightlos.exp1.exception.XException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("role") == null || request.getHeader("uid") == null) {
            throw new XException("未登录");
        }
        int uid = Integer.parseInt(request.getHeader("uid"));
        int role = Integer.parseInt(request.getHeader("role"));
        request.setAttribute("uid", uid);
        request.setAttribute("role", role);
        return true;
    }
}
