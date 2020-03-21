package computer;


public class ComputerStore {
    private static Computer computerA=new Computer("A","intel","Kingston","Seagate","Gigabyte");
    private static Computer computerB=new Computer("B","AMD","Samsung","WestDigitals","Gigabyte");
    private static Computer computerC=new Computer("C","intel","Samsung","Seagate","Asus");;


    public static void computerDiagram(Computer computer){
        System.out.println(computer.getName());
        System.out.println("CPU"+":"+computer.getCpu().getName()+" ");
        computer.getCpu().work();
        System.out.println("Memory:"+computer.getMemory().getName()+" ");
        computer.getMemory().work();
        System.out.println("Disk"+":"+computer.getDisk().getName()+" ");
        computer.getDisk().work();
        System.out.println("Mainboard"+":"+computer.getMainboard().getName()+" ");
        computer.getMainboard().work();
        System.out.println("price:"+computer.getPrice()+"\n");
    }

    public static void main(String[] args) {
        computerDiagram(computerA);
        computerDiagram(computerB);
        computerDiagram(computerC);
    }
}

