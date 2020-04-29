import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) throws InterruptedException {
        double[][] A = MatrixGenerator.matrix();
        double[][] B = MatrixGenerator.matrix(A[0].length);
        Serial.serial(A,B);
        Parallel.parallel(A,B);

    }
}


