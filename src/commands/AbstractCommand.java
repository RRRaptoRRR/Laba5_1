package commands;

import managers.CollectionManager;
import managers.ConsoleManager;

abstract public class AbstractCommand implements Command{
    private String name;
    private String discription;
    public AbstractCommand(String name, String discription){
        this.name=name;
        this.discription=discription;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDiscription() {
        return discription;
    }
}
