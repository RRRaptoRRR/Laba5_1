package commands;

import managers.CollectionManager;

public class Exit extends AbstractCommand{

    public Exit(){
        super("exit", "j");
    }
    @Override
    public boolean execute(String args){
        System.exit(0);
        return true;
    }
}
