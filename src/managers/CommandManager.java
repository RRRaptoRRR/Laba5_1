package managers;

import commands.*;

public class CommandManager {
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    private DataAsker dataAsker;

    private Add add;
    private Help help;
    private Info info;
    private Show show;
    private Update update;

    private RemoveById removeById;


    public CommandManager(CollectionManager collectionManager, ConsoleManager consoleManager){
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
        this.dataAsker=new DataAsker(consoleManager);
        this.add = new Add(consoleManager, collectionManager, this.dataAsker);
        this.help = new Help(consoleManager, collectionManager);
        this.info = new Info(consoleManager, collectionManager);
        this.show = new Show(consoleManager, collectionManager);
        this.update = new Update(consoleManager, collectionManager, this.dataAsker);
        this.removeById = new RemoveById(consoleManager, collectionManager);
    }

    public void RunCommand(String command, String args){
        command= command.toLowerCase();
        switch (command){
            case "help": help.execute(args); break;
            case "info": info.execute(args); break;
            case "show": show.execute(args); break;
            case "add": add.execute(args); break;
            case "update": update.execute(args);break;
            case "remove_by_id": removeById.execute(args);break;
            default:
                consoleManager.print("Команда не распознана" +
                        " Введите help, чтобы узнать доступные команды");
        }
    }
}
