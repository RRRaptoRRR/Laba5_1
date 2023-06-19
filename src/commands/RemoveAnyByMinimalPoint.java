package commands;

import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;

public class RemoveAnyByMinimalPoint extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;



    public RemoveAnyByMinimalPoint(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("remove_any_by_minimal_point", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String args){
        try {
            if(args!=null){
                if (collectionManager.getSize()!=0){
                    float minPoint = Float.parseFloat(args);
                    for(LabWork labWork:collectionManager.getCollection()){
                        if(labWork.getMinimalPoint()==minPoint){
                            collectionManager.remove(labWork);
                            return true;
                        }
                    }
                    consoleManager.print("В коллекции нет LabWork с таким же MinimalPoint");
                }
                else {
                    consoleManager.print("Коллекцимя пуста");
                }
            }
            else {
                consoleManager.print("MinimalPoint не введен");
            }
        }
        catch (NumberFormatException ex){
            consoleManager.print("Неправильный ввод числа");
        }
        return true;
    }
}
