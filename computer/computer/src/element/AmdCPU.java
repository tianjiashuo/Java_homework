package element;

public class AmdCPU implements CPU {
    private static String name="AmdCPU";
    private static int coreNum=50;
    private static int price=50;

    public String getName(){
        return name;
    }
    public int getCoreNum(){
        return coreNum;
    }
    public void setCoreNum(int coreNum){
        this.coreNum=coreNum;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
