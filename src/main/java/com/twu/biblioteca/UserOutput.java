package com.twu.biblioteca;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserOutput {
    public void print(String message) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bufferedWriter.write(message);
        bufferedWriter.flush();
    }

}
