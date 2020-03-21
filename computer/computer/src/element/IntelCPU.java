package element;

public class IntelCPU implements CPU{
    private static String name="IntelCPU";
    private static int coreNum=100;
    private static int price=100;

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
