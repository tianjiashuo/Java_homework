package computer;

import element.*;

public class Computer {
    private String name;
    private CPU cpu;
    private Memory memory;
    private Disk disk;
    private Mainboard mainboard;
    private int price;

    Computer(String name,String cpu,String memory,String disk,String mainboard){
        this.name=name;
        this.cpu=cpu(cpu);
        this.disk=disk(disk);
        this.memory=memory(memory);
        this.mainboard=mainboard(mainboard);
        this.price=this.cpu.getPrice()+this.disk.getPrice()+this.memory.getPrice()+this.mainboard.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPU cpu(String cpu) {
        if(cpu.equals("intel")){
            return new IntelCPU();
        }
        else if(cpu.equals("AMD")){
            return new AmdCPU();
        }
        else{
            return null;
        }
    }

    public CPU getCpu() {
        return cpu;
    }

    public Memory memory(String memory){
        if(memory.equals("Kingston")){
            return new KingstonMemory();
        }
        else if(memory.equals("Samsung")){
            return new SamsungMemory();
        }
        else{
            return null;
        }
    }

    public Memory getMemory() {
        return memory;
    }

    public Disk disk(String disk){
        if(disk.equals("Seagate")){
            return new SeagateDisk();
        }
        else if(disk.equals("WestDigitals")){
            return new WestDigitalsDisk();
        }
        else{
            return null;
        }
    }

    public Disk getDisk() {
        return disk;
    }

    public Mainboard mainboard(String mainboard){
        if(mainboard.equals("Gigabyte")){
            return new GigabyteMainboard();
        }
        else if(mainboard.equals("Asus")){
            return new AsusMainboard();
        }
        else{
            return null;
        }
    }

    public Mainboard getMainboard() {
        return mainboard;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


}
