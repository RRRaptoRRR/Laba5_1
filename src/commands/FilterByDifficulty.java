package commands;

import data.Difficulty;
import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;

public class FilterByDifficulty extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;



    public FilterByDifficulty(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("remove_all_by_difficulty", "j");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String args){
        if (args!=null){
            if (collectionManager.getSize()!=0){
                Difficulty difficult = Difficulty.HARD;
                args = args.toUpperCase();
                switch (args){
                    case "VERY_EASY": difficult = Difficulty.VERY_EASY; break;
                    case "HARD": difficult = Difficulty.HARD; break;
                    case "IMPOSSIBLE": difficult = Difficulty.IMPOSSIBLE; break;
                    case "TERRIBLE": difficult = Difficulty.TERRIBLE; break;
                    default:
                        consoleManager.print("Введена неверная сложность");
                        //flag=false;
                        return false;
                    //break;
                }
                boolean flag= false;
                for (LabWork labWork:collectionManager.getCollection()){
                    if(labWork.getDifficulty() == difficult){
                        consoleManager.print(labWork.toString());
                        flag=true;
                    }
                }
                if (flag){
                    return true;
                }
                else {
                    consoleManager.print("В коллекции нет LabWork с таким Difficulty");
                    return false;
                }
            }
            else {
                consoleManager.print("Коллекция пуста");
                return false;
            }
        }
        else {
            consoleManager.print("Аргумент не введен");
            return false;
        }
    }
}
