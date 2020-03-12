package element;

public interface CPU {
    default void work(){
        System.out.println("CPU work");
    }

    int getPrice();
    String getName();
}
