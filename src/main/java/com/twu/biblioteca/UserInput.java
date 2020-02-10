package com.twu.biblioteca;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int scanOption() {
        return scanner.nextInt();
    }

}
