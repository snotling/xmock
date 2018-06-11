package org.snoth;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robbie on 12/02/2018.
 */
@Slf4j
public class Test {

    @org.junit.Test
    public void test() throws IOException {
        String cmd = "more C:\\Users\\robbie\\sfeirtest.txt";
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        Process process = Runtime.getRuntime()
                    .exec("cmd.exe /c " + cmd);
        StringBuilder ret = new StringBuilder();

        new BufferedReader(new InputStreamReader(process.getInputStream())).lines()
                .forEach(log::info);

    }

}
