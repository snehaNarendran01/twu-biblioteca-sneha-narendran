package com.twu.biblioteca;

import java.io.IOException;

public class UserDetails implements Command {
    private User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public int getOption() {
        return 7;
    }

    @Override
    public void execute() throws IOException {
            user.printInformation();
    }

    @Override
    public int getOptionBeforeLogin() throws InvalidOptionException {
        throw new InvalidOptionException();
    }
}
