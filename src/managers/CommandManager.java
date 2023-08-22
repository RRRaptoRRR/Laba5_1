package managers;

import commands.*;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<String> hist;
    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;
    private DataAsker dataAsker;

    private Add add;
    private Help help;
    private Info info;
    private Show show;
    private Update update;
    private RemoveById removeById;
    private Clear clear;

    private Exit exit;
    private AddIfMax addIfMax;
    private AddIfMin addIfMin;

    private History history;
    private RemoveAllByDifficulty removeAllByDifficulty;

    private RemoveAnyByMinimalPoint removeAnyByMinimalPoint;

    private FilterByDifficulty filterByDifficulty;

    private Read read;

    private Save save;


    public CommandManager(CollectionManager collectionManager, ConsoleManager consoleManager){
        hist = new ArrayList<String>();
        this.collectionManager=collectionManager;
        this.consoleManager=consoleManager;
        this.dataAsker=new DataAsker(consoleManager);
        this.add = new Add(consoleManager, collectionManager, this.dataAsker);
        this.help = new Help(consoleManager, collectionManager);
        this.info = new Info(consoleManager, collectionManager);
        this.show = new Show(consoleManager, collectionManager);
        this.update = new Update(consoleManager, collectionManager, this.dataAsker);
        this.removeById = new RemoveById(consoleManager, collectionManager);
        this.clear = new Clear(collectionManager);
        this.read = new Read(consoleManager, collectionManager);
        this.save = new Save(consoleManager, collectionManager);

        this.exit = new Exit();
        this.addIfMax = new AddIfMax(consoleManager, collectionManager, this.dataAsker);
        this.addIfMin = new AddIfMin(consoleManager, collectionManager, this.dataAsker);
        this.history = new History(consoleManager, hist);
        this.removeAllByDifficulty = new RemoveAllByDifficulty(consoleManager, collectionManager);
        this.removeAnyByMinimalPoint = new RemoveAnyByMinimalPoint(consoleManager, collectionManager);
        this.filterByDifficulty = new FilterByDifficulty(consoleManager, collectionManager);
    }

    public void RunCommand(String command, String args){
        command= command.toLowerCase();
        switch (command){
            case "help": help.execute(args); hist.add(help.getName()); break;
            case "info": info.execute(args); hist.add(info.getName()); break;
            case "show": show.execute(args); hist.add(show.getName()); break;
            case "add": add.execute(args); hist.add(add.getName()); break;
            case "update": update.execute(args); hist.add(update.getName()); break;
            case "remove_by_id": removeById.execute(args); hist.add(removeById.getName()); break;
            case "clear": clear.execute(args); hist.add(clear.getName()); break;
            case "read": read.execute(args); hist.add(read.getName()); break;
            case "save": save.execute(args); hist.add(read.getName()); break;

            case "exit": exit.execute(args); hist.add(exit.getName()); break;
            case "add_if_max": addIfMax.execute(args); hist.add(addIfMin.getName()); break;
            case "add_if_min": addIfMin.execute(args); hist.add(addIfMax.getName()); break;
            case "history": history.execute(args); hist.add(history.getName()); break;
            case "remove_all_by_difficulty": removeAllByDifficulty.execute(args); hist.add(removeAllByDifficulty.getName()); break;
            case "remove_any_by_minimal_point": removeAnyByMinimalPoint.execute(args); hist.add(removeAnyByMinimalPoint.getName()); break;
            case "filter_by_difficulty": filterByDifficulty.execute(args); hist.add(filterByDifficulty.getName()); break;
            default:
                consoleManager.print("Команда не распознана" +
                        "Введите help, чтобы узнать доступные команды");
        }
        /*if(hist.size()>7){
            hist.remove(0);
        }*/
    }
}
