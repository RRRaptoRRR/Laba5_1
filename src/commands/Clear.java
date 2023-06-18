package commands;

import managers.CollectionManager;
import managers.ConsoleManager;
import managers.DataAsker;

public class Clear extends AbstractCommand{
    private CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager){
        super("clear", "j");
        this.collectionManager=collectionManager;
    }
    @Override
    public boolean execute(String args){
        collectionManager.clear();
        return true;
    }
}
