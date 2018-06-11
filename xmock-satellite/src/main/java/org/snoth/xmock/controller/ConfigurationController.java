package org.snoth.xmock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.snoth.xmock.bean.Mock;
import org.snoth.xmock.configuration.CacheMockMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by robbie on 21/02/2018.
 */
@Component
public class ConfigurationController implements IController {

    private final RestartEndpoint restartEndpoint;

    @Autowired
    public ConfigurationController(RestartEndpoint restartEndpoint) {
        this.restartEndpoint = restartEndpoint;
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if ("/createMock".equals(request.getServletPath()) && "POST".equalsIgnoreCase(request.getMethod())) {
            ObjectMapper mapper = new ObjectMapper();
            Mock mock = mapper.readValue(request.getReader(), Mock.class);
         //   createMock(mock);
        }

    }

    @Override
    public boolean is(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    private void createMock(Mock mock) throws IOException {
        CacheMockMap.addMock(mock);
        if (mock.isAutoStart()) {
            Thread restartThread = new Thread(() -> restartEndpoint.restart());
            restartThread.setDaemon(false);
            restartThread.start();
        }
    }

    private void stopMock(Mock mock) throws IOException {
        CacheMockMap.stopMock(mock);
        if (mock.isAutoStart()) {
            Thread restartThread = new Thread(() -> restartEndpoint.restart());
            restartThread.setDaemon(false);
            restartThread.start();
        }
    }

    private void startMock(Mock mock) throws IOException {
        CacheMockMap.startMock(mock);
        if (mock.isAutoStart()) {
            Thread restartThread = new Thread(() -> restartEndpoint.restart());
            restartThread.setDaemon(false);
            restartThread.start();
        }
    }

}
