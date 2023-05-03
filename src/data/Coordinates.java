package data;

public class Coordinates {
    private int x;
    private Integer y; //Поле не может быть null

    public Coordinates(int x, Integer y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public Integer getY(){
        return this.y;
    }
}
