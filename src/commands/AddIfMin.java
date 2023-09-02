package commands;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;
import exceptions.InvalidInputException;
import exceptions.InvalidInputRangeException;
import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

import java.io.BufferedReader;
import java.io.IOException;

public class AddIfMin extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    private DataAsker dataAsker;
    public AddIfMin(ConsoleManager consoleManager, CollectionManager collectionManager, DataAsker dataAsker){
        super("add_if_min", "j");
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
        if (laba.getMinimalPoint()<collectionManager.getMinByPoints()){
            collectionManager.add(laba);
        }
        else {
            System.out.println("Введенный Вами MinimalPoint не является минимальным");
        }
        return true;
    }

    public boolean executeFromScript(String args, BufferedReader csvReader){
        try {
            String LabName = csvReader.readLine();
            int X = Integer.parseInt(csvReader.readLine());
            int Y = Integer.parseInt(csvReader.readLine());
            float Point = Float.parseFloat(csvReader.readLine());
            if (Point<=0){
                throw new InvalidInputException("Кол-во баллов не может быть меньше или ровно 0");
            }
            Difficulty Difficult = Difficulty.HARD;

            String difficult=csvReader.readLine().toUpperCase();
            switch (difficult){
                case "VERY_EASY": Difficult = Difficulty.VERY_EASY; break;
                case "HARD": Difficult = Difficulty.HARD; break;
                case "IMPOSSIBLE": Difficult = Difficulty.IMPOSSIBLE; break;
                case "TERRIBLE": Difficult = Difficulty.TERRIBLE; break;
                default:
                    throw new InvalidInputException("Введена неверная сложность");
            }
            String PersonName=csvReader.readLine();
            long Height = Long.parseLong(csvReader.readLine());
            if(Height<=0){
                throw new InvalidInputRangeException("Рост не может быть меньше или ровно  0");
                //consoleManager.print("Рост не может быть меньше 0");
            }
            Integer Weight = Integer.parseInt(csvReader.readLine());
            if (Weight <= 0) {
                throw new InvalidInputRangeException("Вес не может быть меньше или ровно 0");
                //consoleManager.print("Вес не может быть меньше 0");
            }
            LabWork laba = new LabWork(LabName, new Coordinates(X, Y), Point, Difficult,
                    new Person(PersonName, Height, Weight));
            if (laba.getMinimalPoint()<collectionManager.getMinByPoints()){
                collectionManager.add(laba);
            }
            else {
                System.out.println("Введенный Вами MinimalPoint не является максимальным");
            }
            return true;
        }
        catch (IOException ex){
            consoleManager.print("файл не считался");
        }
        catch (InvalidInputException ex){
            consoleManager.print(ex.getMessage());
        }
        catch (InvalidInputRangeException ex){
            consoleManager.print(ex.getMessage());
        }
        return false;

    }
}
