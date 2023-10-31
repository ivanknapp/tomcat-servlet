package ru.knapp.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.knapp.service.MyService;

import java.io.IOException;

@WebServlet("/spring")
@Service
public class MySpringServlet extends HttpServlet {
    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hello, %s</h1>".formatted(myService.getMyServiceMethod()));
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        /**
         * так как спринг не управляет созданием HttpServlet, инжектить зависимости надо самостоятельно
         */
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}