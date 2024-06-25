package com.team6.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/InsertRes")
public class ReserveFilter implements Filter {
       
    public ReserveFilter() {
    }
//    public ReserveConfirm() {
//    }
    
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String checkin = request.getParameter("checkin");
        if (checkin != null && checkin.equals("confirm")) {
            httpRequest.getRequestDispatcher("./reservation/jsp/reservationDataConfirm.jsp").forward(httpRequest, httpResponse);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
