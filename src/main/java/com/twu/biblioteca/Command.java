package com.twu.biblioteca;

import java.io.IOException;

public interface Command {
    int getOption();

    void execute() throws IOException;

    int getOptionBeforeLogin();
}
