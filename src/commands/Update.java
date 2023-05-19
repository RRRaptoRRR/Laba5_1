package commands;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Person;
import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

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
}
