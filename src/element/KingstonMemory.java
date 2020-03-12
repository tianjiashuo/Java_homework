package element;

public class KingstonMemory implements Memory{
    private String name = "KingstonMemory";
    private int volume = 200;
    private int price = 200;
    public String getName(){
        return name;
    }
    public int getVolume(){
        return volume;
    }
    public void setVolume(int volume){
        this.volume=volume;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
