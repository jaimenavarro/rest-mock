package com.jns.rest.mock.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        log.info("--------------------------------------------------------------------------");
        log.info("preHandle => Request Method: {}, URL: {}",request.getMethod() ,requestURL);
        log.debug("------------------------------");
        log.debug("HEADERS:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
           String header = headerNames.nextElement();
            log.debug(header + ": " + request.getHeader(header));
        }
        log.debug("------------------------------");
        log.debug("PARAM:");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            log.debug(param + ": " + request.getParameter(param));
        }

        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        int status = response.getStatus();
        log.info("afterCompletion => Response Status: {}", status);
        log.info("--------------------------------------------------------------------------");

    }
}
