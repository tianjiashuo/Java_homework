package element;

public class AsusMainboard implements Mainboard {
    private String name = "AsusMainboard";
    private int speed = 1000;
    private int price = 100;
    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
