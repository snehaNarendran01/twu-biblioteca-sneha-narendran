package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int scanOption() {
        return scanner.nextInt();
    }

    public String scanBookTitle() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public String scanMovieTitle() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
