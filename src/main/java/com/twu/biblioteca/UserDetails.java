package com.twu.biblioteca;

import java.io.IOException;

public class UserDetails implements Command {
    private User user;
    private Validator validator;

    public UserDetails(User user, Validator validator) {
        this.user = user;
        this.validator = validator;
    }

    @Override
    public int getOption() {
        return 7;
    }

    @Override
    public void execute() throws IOException {
        if (validator.isValid())
            user.printInformation();
    }

    @Override
    public int getOptionBeforeLogin() {
        return 0;
    }
}
