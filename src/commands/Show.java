package commands;

import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;

public class Show extends AbstractCommand {
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    public Show(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("show", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute() {
        if (collectionManager.getSize()!=0){
            for (LabWork labWork:collectionManager.getCollection()){
                consoleManager.print(labWork.toString());
            }
            return true;
        }
        else{
            consoleManager.print("Коллекция пуста");
            return false;
        }

    }
}
