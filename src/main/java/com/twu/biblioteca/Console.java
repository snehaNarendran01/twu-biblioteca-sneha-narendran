package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public void print(String message) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(message);
        bufferedWriter.flush();
    }

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

    public String scanLibraryNumber() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public String scanUserPassword() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
