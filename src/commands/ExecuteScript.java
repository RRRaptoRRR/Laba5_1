package commands;

import managers.CollectionManager;
import managers.CommandManager;
import managers.ConsoleManager;
import managers.DataAsker;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScript extends AbstractCommand{


    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;
    private DataAsker dataAsker;

    private CommandManager commandManager;
    public ExecuteScript (ConsoleManager consoleManager, CollectionManager collectionManager, CommandManager commandManager){
        super("execute_script", "execute_script");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
        this.commandManager = commandManager;
    }

    @Override
    public boolean execute(String args) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(args));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String [] Input;
                String command=null;
                String arg= null;
                Input=row.trim().split(" ");
                if (Input.length==1){
                    command=Input[0];
                }
                else if(Input.length==2) {
                    command=Input[0];
                    arg=Input[1];
                }
                else{
                    consoleManager.print("Введено слишком много аргументов");
                    continue;
                }
                commandManager.RunCommandFromScript(command, arg, csvReader);
            }
            csvReader.close();
            return true;
        }
        catch (IOException ex){
            consoleManager.print("Файл не считался");
        }
        return false;

    }
}
