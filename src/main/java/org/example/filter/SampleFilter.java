package org.example.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

public class SampleFilter implements javax.servlet.Filter {

    Logger log = Logger.getLogger(SampleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        addCookieAttributeToJsessionid((HttpServletRequest) request, (HttpServletResponse) response);
        chain.doFilter(request, response);
    }

    private void addCookieAttributeToJsessionid(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(true);
        String sessionId = httpSession.getId();
        response.addHeader(HttpHeaders.SET_COOKIE, String.format("JSESSIONID=%s; SameSite=%s; HttpOnly=%s", sessionId, "Strict", "true"));
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
