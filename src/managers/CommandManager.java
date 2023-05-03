package managers;

import commands.Add;
import commands.Help;
import commands.Info;
import commands.Show;

public class CommandManager {
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    private Add add;
    private Help help;
    private Info info;
    private Show show;


    public CommandManager(CollectionManager collectionManager, ConsoleManager consoleManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
        this.add = new Add(consoleManager, collectionManager);
        this.help = new Help(consoleManager, collectionManager);
        this.info = new Info(consoleManager, collectionManager);
        this.show = new Show(consoleManager, collectionManager);
    }

    public void RunCommand(String command, String args){
        command= command.toLowerCase();
        switch (command){
            case "help": help.execute(); break;
            case "info": info.execute(); break;
            case "show": show.execute(); break;
            case "add": add.execute(); break;
            default:
                consoleManager.print("Команда не распознана" +
                        " Введите help, чтобы узнать доступные команды");
        }
    }
}
