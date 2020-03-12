package element;

public class GigabyteMainboard implements Mainboard {
    private String name = "GigabyteMainboard";
    private int speed = 2000;
    private int price = 200;
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
