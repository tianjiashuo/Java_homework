package element;

public interface Memory {
    default void work(){
        System.out.println("Memory work");
    }

    int getPrice();
    String getName();
}
