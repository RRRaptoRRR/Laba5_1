package managers;

import java.util.Scanner;

public class ConsoleManager {
    private Scanner scanner;
    private CollectionManager collectionManager;
    private CommandManager commandManager;


    public ConsoleManager(Scanner scanner){
        this.scanner=scanner;
    }
    public  void start(CollectionManager collectionManager, CommandManager commandManager){
        this.collectionManager=collectionManager;
        this.commandManager=commandManager;
        print("Введите help, чтобы узнать доступные команды");
        while (true){
            System.out.print("$");
            //print("$");
            String [] Input;
            String command=null;
            String arg= null;
            Input=input().trim().split(" ");
            if (Input.length==1){
                command=Input[0];
            }
            else if(Input.length==2) {
                command=Input[0];
                arg=Input[1];
            }
            else{
                print("Введено слишком много аргументов");
                continue;
            }
            commandManager.RunCommand(command, arg);

        }
    }

    public void print(String printable){
        System.out.println(printable);
    }
    public String input(String print){
        System.out.println(print);
        String str=scanner.nextLine();
        return str;
    }
    public String input(){
        String str=scanner.nextLine();
        return str;
    }
}
