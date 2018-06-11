package org.snoth.xmock.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by robbie on 12/02/2018.
 */
@Slf4j
@RestController
public class GenericController {

    @Value("${server.port}")
    private int SERVER_PORT;

    private final MockController mockController;
    private final ConfigurationController configurationController;
    private final TerminalController terminalController;

    @Autowired
    public GenericController(MockController mockController, ConfigurationController configurationController, TerminalController terminalController) {
        this.mockController = mockController;
        this.configurationController = configurationController;
        this.terminalController = terminalController;
    }

    @RequestMapping("/**")
    public void filterPath(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("URL: " + request.getRequestURL().toString());
        log.info("URI: " + request.getRequestURI());
        request.getParameterMap().keySet().forEach(k -> log.info("[" + k + "] : " + request.getParameterMap().get(k)));
        log.info("Port: " + request.getServerPort());
        log.info("Path: " + request.getServletPath());
        log.info("Method: " + request.getMethod());

        //The request targets the port on the satellite so it's a command
        if (SERVER_PORT == request.getServerPort()) {

        } else {
            mockController.dispatch(request, response);
        }

    }

}
