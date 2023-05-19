package commands;

import managers.ConsoleManager;

public interface Command {
    String getName();
    String getDiscription();

    boolean execute(String args);
}
