package com.twu.biblioteca;

public class Login implements Command {
    private Validator validator;
    private Console console;

    public Login(Console console, Validator validator) {
        this.console = console;
        this.validator = validator;
    }

    @Override
    public int getOption() {
        return -1;
    }

    @Override
    public void execute() {
    }

    @Override
    public int getOptionBeforeLogin() {
        return 3;
    }
}
