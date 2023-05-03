package managers;

import data.LabWork;

import java.time.LocalDate;
import java.util.TreeSet;

public class CollectionManager {
    private TreeSet<LabWork> collection;
    private  java.time.LocalDate initDate;

    public CollectionManager(){
        this.collection=new TreeSet<>();
        this.initDate=LocalDate.now();
    }
    public TreeSet<LabWork> getCollection() {
        return collection;
    }
    public int getSize(){
        return collection.size();
    }

    public LocalDate getInitDate() {
        return initDate;
    }
    public void add(LabWork labWork){
        collection.add(labWork);
    }
}
