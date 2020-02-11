package com.twu.biblioteca;

public class SystemExit implements Command {
    private ApplicationQuitter applicationQuitter;

    SystemExit(ApplicationQuitter applicationQuitter) {
        this.applicationQuitter = applicationQuitter;
    }

    @Override
    public int getOption() {
        return 4;
    }

    @Override
    public void execute() {
        applicationQuitter.exitSystem();
    }
}
