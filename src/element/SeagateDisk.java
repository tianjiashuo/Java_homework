package element;

public class SeagateDisk implements Disk {
    private String name = "SeagateDist";
    private int volume = 1000;
    private int price = 100;
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
