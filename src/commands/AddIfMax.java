package commands;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;
import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

public class AddIfMax extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    private DataAsker dataAsker;
    public AddIfMax(ConsoleManager consoleManager, CollectionManager collectionManager, DataAsker dataAsker){
        super("add_if_max", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
        this.dataAsker = dataAsker;
    }
    @Override
    public boolean execute(String args){
        String LabName = dataAsker.AskLabName();
        consoleManager.print("Введите координаты:");
        int X = dataAsker.AskX();
        int Y = dataAsker.AskY();
        float Point =dataAsker.AskPoint();
        Difficulty Difficult = dataAsker.AskDifficult();
        String Name = dataAsker.AskPersonName();
        long height = dataAsker.AskHeight();
        Integer weight = dataAsker.AskWeight();
        LabWork laba = new LabWork(LabName, new Coordinates(X, Y), Point, Difficult,
                new Person(Name, height, weight));
        if (laba.getMinimalPoint()>collectionManager.getMaxByPoints()){
            collectionManager.add(laba);
        }
        else {
            System.out.println("Введенный Вами MinimalPoint не является максимальным");
        }
        return true;
    }
}
