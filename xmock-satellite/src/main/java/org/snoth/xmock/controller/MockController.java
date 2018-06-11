package org.snoth.xmock.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.snoth.xmock.bean.Mock;
import org.snoth.xmock.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by robbie on 21/02/2018.
 */
@Component
@Slf4j
public class MockController {

    private final MockService mockService;

    @Autowired
    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<Mock> mock = mockService.matchMock(request.getServerPort(), request.getServletPath(), request.getMethod());
        mock.ifPresent(m -> {
            try {
                response.setContentType("application/json");
                response.getOutputStream().print("{\"test\": 12}");
            } catch (Exception e) {
                log.error("Error during ...");
            }
        });
        if (!mock.isPresent()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
