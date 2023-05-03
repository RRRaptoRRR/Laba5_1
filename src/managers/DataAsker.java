package managers;

import data.Difficulty;

public class DataAsker {

    private ConsoleManager consoleManager;
    public DataAsker(ConsoleManager consoleManager){
        this.consoleManager=consoleManager;
    }

    public String AskLabName(){
        String LabName="";
        while (true){
           LabName = consoleManager.input("Введите название лабораторной:");
           if (LabName==null){
               consoleManager.print("Название лабораторной не может быть пустым");
           }
           else break;
        }
        return LabName;
    }
    public int AskX(){
        //consoleManager.print("Введите X:");
        int X;
        while (true){
            //try {
                String x= consoleManager.input("Введите X:");
                if (x==null || x==""){
                    consoleManager.print("Координата X не может быть пустой");
                }
                else {
                    X = Integer.parseInt(x);
                    break;
                }
            //}
            /*catch (NumberFormatException){
                consoleManager.print("Координата X не может быть пустой");
            }*/

        }
        return X;
    }
    public Integer AskY(){
        Integer Y;
        //consoleManager.print("Введите Y:");
        while (true){
            String y= consoleManager.input("Введите Y:");
            if (y==null){
                consoleManager.print("Координата Y не может быть пустой");
            }
            else {
                Y = Integer.parseInt(y);
                break;
            }
        }
        return Y;
    }
    public Integer AskPoint(){
        Integer Point;
        //consoleManager.print("Введите Y:");
        while (true){
            String point= consoleManager.input("Введите Кол-во баллов:");
            if (point==null){
                consoleManager.print("Кол-во баллов не может быть пустым");
            }
            else {
                Point = Integer.parseInt(point);
                if(Point<=0){
                    consoleManager.print("Кол-во баллов не может быть меньше 0");
                }
                else break;
            }
        }
        return Point;
    }
    public Difficulty AskDifficult(){
        Difficulty Difficult = Difficulty.HARD;
        while (true){
            consoleManager.print("Введите сложность данной лабы:");
            String difficult = consoleManager.input("VERY_EASY, HARD, IMPOSSIBLE, TERRIBLE: ");
            if (difficult==null){
                consoleManager.print("Сложность не может быть пустым");
            }
            else {
                boolean flag=true;
                difficult=difficult.toUpperCase();
                switch (difficult){
                    case "VERY_EASY": Difficult = Difficulty.VERY_EASY; break;
                    case "HARD": Difficult = Difficulty.HARD; break;
                    case "IMPOSSIBLE": Difficult = Difficulty.IMPOSSIBLE; break;
                    case "TERRIBLE": Difficult = Difficulty.TERRIBLE; break;
                    default:
                        consoleManager.print("ВВедена не верная сложность");
                        flag=false;
                        break;
                }
                if (flag) break;
            }
        }
        return Difficult;
    }
    public String AskPersonName(){
        String PersonName="";
        while (true){
            PersonName = consoleManager.input("Введите имя студента");
            if (PersonName==null){
                consoleManager.print("Имя не может быть пустым");
            }
            else break;
        }
        return PersonName;
    }
    public long AskHeight(){
        long Height;
        //consoleManager.print("Введите Y:");
        while (true){
            String height= consoleManager.input("Введите рост студента:");
            if (height==null){
                consoleManager.print("Рост не может быть пустым");
            }
            else {
                Height = Long.parseLong(height);
                if(Height<=0){
                    consoleManager.print("Рост не может быть меньше 0");
                }
                else break;
            }
        }
        return Height;
    }
    public Integer AskWeight(){
        Integer Weight;
        //consoleManager.print("Введите Y:");
        while (true){
            String weight= consoleManager.input("Введите вес студента:");
            if (weight==null){
                consoleManager.print("Вес не может быть пустым");
            }
            else {
                Weight = Integer.parseInt(weight);
                if(Weight<=0){
                    consoleManager.print("Вес не может быть меньше 0");
                }
                else break;
            }
        }
        return Weight;
    }
}