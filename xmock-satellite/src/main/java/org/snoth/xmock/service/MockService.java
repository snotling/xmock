package org.snoth.xmock.service;

import org.snoth.xmock.bean.Mock;
import org.snoth.xmock.configuration.CacheMockMap;

import java.util.Optional;

/**
 * Created by robbie on 16/02/2018.
 */
public class MockService {

    public Optional<Mock> matchMock(int port, String path, String method) {
        return CacheMockMap.getMocks().stream()
                .filter(m -> m.getPort() == port)
                .filter(m -> m.getPath().equals(path)) //TODO match request with path variable
                .filter(m -> m.getMethod().equals(method))
                .findFirst();
    }


}
