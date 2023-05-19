package commands;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;
import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

public class Add extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private DataAsker dataAsker;

    public Add(ConsoleManager consoleManager, CollectionManager collectionManager, DataAsker dataAsker){
        super("add", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
        this.dataAsker = dataAsker;
    }
    @Override
    public boolean execute(String args) {
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
        //System.out.println("Получены следующие данные:");
        //System.out.println(laba.toString());
        collectionManager.add(laba);
        return true;
    }
}
