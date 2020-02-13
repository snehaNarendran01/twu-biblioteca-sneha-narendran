package com.twu.biblioteca;

import java.io.IOException;

public class Login implements Command {
    private Validator validator;

    public Login(Validator validator) {
        this.validator = validator;
    }

    @Override
    public int getOption() {
        return -1;
    }

    @Override
    public void execute() throws IOException {
        validator.isValid();
    }

    @Override
    public int getOptionBeforeLogin() {
        return 3;
    }
}
