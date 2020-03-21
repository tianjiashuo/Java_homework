package element;

public class WestDigitalsDisk implements Disk {
    private String name = "SeagateDist";
    private int volume = 2000;
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
