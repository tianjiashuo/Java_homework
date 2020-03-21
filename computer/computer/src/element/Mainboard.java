package element;

public interface Mainboard {
    default void work() {
        System.out.println("Mainboard work");
    }

    int getPrice();
    String getName();
}
