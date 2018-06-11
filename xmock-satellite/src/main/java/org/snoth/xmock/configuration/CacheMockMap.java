package org.snoth.xmock.configuration;

import org.snoth.xmock.bean.Mock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by robbie on 12/02/2018.
 */
public class CacheMockMap {

    private static final Set<Mock> mocks = new HashSet<>();

    public static synchronized void addMock(Mock mock) {
        mocks.add(mock);
    }

    public static synchronized Set<Mock> getMocks() {
        return mocks;
    }

    public static synchronized void stopMock(Mock mock) {
        mocks.stream()
                .filter(m -> m.equals(mock))
                .findFirst()
                .ifPresent(m -> {
                    m.stop();
                    doAction(m.getStopAction());
                });
    }

    public static synchronized void startMock(Mock mock) {
        mocks.stream()
                .filter(m -> m.equals(mock))
                .findFirst()
                .ifPresent(m -> {
                    m.start();
                    doAction(m.getStartAction());
                });
    }

    private static void doAction(String action) {
    }
}
