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

public class Update extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private DataAsker dataAsker;
    public Update(ConsoleManager consoleManager, CollectionManager collectionManager, DataAsker dataAsker){
        super("update", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
        this.dataAsker=dataAsker;
    }

    @Override
    public boolean execute(String args) {
        try{
            if (args!=null){
                if (collectionManager.getSize()!=0){
                    long id = Long.parseLong(args);
                    boolean flag=true;
                    for (LabWork labWork:collectionManager.getCollection()){
                        if (java.lang.Long.compare(labWork.getId(), id)==0){
                            //collectionManager.remove(labWork);
                            update(labWork);
                            flag=false;
                            return true;
                        }
                    }
                    if( flag) {
                        consoleManager.print("В коллекции нет LabWork с таким id");
                        return false;
                    }
                }
                else{
                    consoleManager.print("Коллекция пуста");
                    return false;
                }
            }
            else {
                consoleManager.print("Аргумент не введен");
                return false;
            }

        }
        catch (NumberFormatException ex) {
            consoleManager.print("Неправильно введен аргумент");
            return false;
        }
        return true;
    }
    private void update(LabWork labWork){
        consoleManager.print("Предыдущее значение названия лабораторной: "+ labWork.getName());
        labWork.setName(dataAsker.AskLabName());
        consoleManager.print("Введите координаты:");
        consoleManager.print("Предыдущее значение X: "+ labWork.getCoordinates().getX());
        int X = dataAsker.AskX();
        consoleManager.print("Предыдущее значение X: "+ labWork.getCoordinates().getY());
        int Y = dataAsker.AskY();
        labWork.setCoordinates(new Coordinates(X, Y));
        consoleManager.print("Предыдущее количество баллов: "+ labWork.getMinimalPoint());
        labWork.setMinimalPoint(dataAsker.AskPoint());
        consoleManager.print("Предыдущее сложность: "+ labWork.getDifficulty());
        labWork.setDifficulty(dataAsker.AskDifficult());
        consoleManager.print("Предыдущее имя автора: "+ labWork.getAuthor().getName());
        String Name = dataAsker.AskPersonName();
        consoleManager.print("Предыдущее рост автора: "+ labWork.getAuthor().getHeight());
        long height = dataAsker.AskHeight();
        consoleManager.print("Предыдущее вес автора: "+ labWork.getAuthor().getWeight());
        Integer weight = dataAsker.AskWeight();
        labWork.setAuthor(new Person(Name, height, weight));
    }

    public boolean executeFromScript(String args, BufferedReader csvReader){
        try{
            if (args!=null){
                if (collectionManager.getSize()!=0){
                    long id = Long.parseLong(args);
                    boolean flag=true;
                    for (LabWork labWork:collectionManager.getCollection()){
                        if (java.lang.Long.compare(labWork.getId(), id)==0){
                            //collectionManager.remove(labWork);
                            updateFromScript(labWork, csvReader);
                            flag=false;
                            return true;
                        }
                    }
                    if( flag) {
                        consoleManager.print("В коллекции нет LabWork с таким id");
                        return false;
                    }
                }
                else{
                    consoleManager.print("Коллекция пуста");
                    return false;
                }
            }
            else {
                consoleManager.print("Аргумент не введен");
                return false;
            }
        }
        catch (NumberFormatException ex) {
            consoleManager.print("Неправильно введен аргумент");
            return false;
        }
        return true;
    }

    public boolean updateFromScript(LabWork labWork, BufferedReader csvReader){
        try {
            String LabName = csvReader.readLine();
            labWork.setName(LabName);
            int X = Integer.parseInt(csvReader.readLine());
            int Y = Integer.parseInt(csvReader.readLine());
            labWork.setCoordinates(new Coordinates(X, Y));
            float Point = Float.parseFloat(csvReader.readLine());
            if (Point<=0){
                throw new InvalidInputException("Кол-во баллов не может быть меньше или ровно 0");
            }
            labWork.setMinimalPoint(Point);


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

            labWork.setDifficulty(Difficult);

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
            labWork.setAuthor( new Person(PersonName, Height, Weight));
        }
        catch (IOException ex){
            consoleManager.print("данные не считались");
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
