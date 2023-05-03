import managers.CollectionManager;
import managers.CommandManager;
import managers.ConsoleManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager();
        ConsoleManager consoleManager = new ConsoleManager(scanner);
        CommandManager commandManager = new CommandManager(collectionManager, consoleManager);
        consoleManager.start(collectionManager, commandManager);
    }
}