package commands;

import data.LabWork;
import managers.CollectionManager;
import managers.ConsoleManager;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends AbstractCommand{
    private ConsoleManager consoleManager;
    private CollectionManager collectionManager;

    public Save(ConsoleManager consoleManager, CollectionManager collectionManager){
        super("save", "save collection to csv");
        this.consoleManager=consoleManager;
        this.collectionManager=collectionManager;
    }

    @Override
    public boolean execute(String args) {
        try {
            FileWriter csvWriter = new FileWriter(args);
            csvWriter.append("labname,x,y,points,difficult,studname,height,weight");
            csvWriter.append("\n");
            for (LabWork labWork:collectionManager.getCollection()){
                csvWriter.append(labWork.getName());
                csvWriter.append(",");
                csvWriter.append(Integer.toString(labWork.getCoordinates().getX()));
                csvWriter.append(",");
                csvWriter.append(labWork.getCoordinates().getY().toString());
                csvWriter.append(",");
                csvWriter.append(labWork.getMinimalPoint().toString());
                csvWriter.append(",");
                csvWriter.append(labWork.getDifficulty().toString());
                csvWriter.append(",");
                csvWriter.append(labWork.getAuthor().getName());
                csvWriter.append(",");
                csvWriter.append(Long.toString(labWork.getAuthor().getHeight()));
                csvWriter.append(",");
                csvWriter.append(labWork.getAuthor().getWeight().toString());
                csvWriter.append("\n");

            }
            csvWriter.flush();
            csvWriter.close();
            return true;
        }
        catch (FileNotFoundException ex){
            System.out.println("Указан неверный путь");
        }
        catch (IOException ex){
            System.out.println("*_*");
        }
        return false;
    }
}
