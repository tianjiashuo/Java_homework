package element;

public interface Disk {
    default void work(){
        System.out.println("Disk work");
    }
}
