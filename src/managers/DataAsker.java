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
            try {
                String x= consoleManager.input("Введите X:");
                X = Integer.parseInt(x);
                break;
            }
            catch (NumberFormatException ex) {
                consoleManager.print("Неправильные формат данных");
            }
        }
        return X;
    }
    public Integer AskY(){
        Integer Y;
        //consoleManager.print("Введите Y:");
        while (true){
            try {
                String y= consoleManager.input("Введите Y:");
                Y = Integer.parseInt(y);
                break;
            }

            catch (NumberFormatException ex) {
                consoleManager.print("Неправильные формат данных");
            }
        }
        return Y;
    }
    public float AskPoint(){
        float Point;
        //consoleManager.print("Введите Y:");
        while (true){
            try {
                String point= consoleManager.input("Введите Кол-во баллов:");
                Point = Float.parseFloat(point);
                if(Point<=0){
                    consoleManager.print("Кол-во баллов не может быть меньше 0");
                }
                else break;
            }
            catch (NumberFormatException ex) {
                consoleManager.print("Неправильные формат данных");
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
                        consoleManager.print("Введена не верная сложность");
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
            try {
                String height= consoleManager.input("Введите рост студента:");
                Height = Long.parseLong(height);
                if(Height<=0){
                    consoleManager.print("Рост не может быть меньше 0");
                }
                else break;
            }
            catch (NumberFormatException ex) {
                consoleManager.print("Неправильные формат данных");
            }
        }
        return Height;
    }
    public Integer AskWeight(){
        Integer Weight;
        //consoleManager.print("Введите Y:");
        while (true){
            try {
                String weight = consoleManager.input("Введите вес студента:");
                Weight = Integer.parseInt(weight);
                if (Weight <= 0) {
                    consoleManager.print("Вес не может быть меньше 0");
                } else break;
            }
            catch (NumberFormatException ex) {
                consoleManager.print("Неправильные формат данных");
            }

        }
        return Weight;
    }
}
