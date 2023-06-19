package commands;

import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

public class RemoveById extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    public RemoveById(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("remove_by_id", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String args) {
        try{
            if (args!=null){
                if (collectionManager.getSize()!=0){
                    long id = Long.parseLong(args);
                    for (LabWork labWork:collectionManager.getCollection()){
                        if (java.lang.Long.compare(labWork.getId(), id)==0){
                            collectionManager.remove(labWork);

                            return true;
                        }
                    }
                    consoleManager.print("В коллекции нет LabWork с таким id");
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
}
