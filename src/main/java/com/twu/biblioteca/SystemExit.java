package com.twu.biblioteca;

public class SystemExit implements Command {
    @Override
    public int getOption() {
        return 4;
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
