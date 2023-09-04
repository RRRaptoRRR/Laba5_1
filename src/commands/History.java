package commands;

import managers.ConsoleManager;

import java.util.ArrayList;

public class History extends AbstractCommand{

    private ConsoleManager consoleManager;

    private ArrayList<String> history;
    public History(ConsoleManager consoleManager, ArrayList<String> history){
        super("history", "g");
        this.consoleManager = consoleManager;
        this.history = history;

    }

    @Override
    public boolean execute(String args) {
        if(history.size()==0){
            consoleManager.print("Вы не ввели еще ни одной команды");
            return false;
        }
        else {
            consoleManager.print("7 последних выполненных команд:");
            int i =history.size()-1;
            for (int kol =0; kol<7; kol++){
                consoleManager.print(history.get(i));
                i--;
                if (i<0) break;
            }
            /*for (String command: history){
                consoleManager.print(command);
            }*/
            return true;
        }

    }
}
