package commands;

import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;

import java.util.TreeSet;

public class Info extends AbstractCommand{
    //private TreeSet<LabWork> collection;
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    public Info(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("info", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute() {
        consoleManager.print("Тип хранимого объекта: "+ collectionManager.getCollection().getClass().getName());
        consoleManager.print("Дата инициализации: "+collectionManager.getInitDate().toString());
        consoleManager.print("Количество элементов: "+collectionManager.getSize());
       /*for (LabWork labWork:collectionManager.getCollection()){
        }*/
        return true;
    }
}
