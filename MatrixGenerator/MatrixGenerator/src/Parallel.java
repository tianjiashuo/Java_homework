import java.util.concurrent.CountDownLatch;
public class Parallel extends Thread {
    private double[][] A;
    private double[][] B;
    private int index;
    private int gap;
    private double[][] result;
    private CountDownLatch countDownLatch;

    public Parallel(double[][] A, double[][] B, int index, int gap, double[][] result, CountDownLatch countDownLatch) {
        this.A = A;
        this.B = B;
        this.index = index;
        this.gap = gap;
        this.result = result;
        this.countDownLatch = countDownLatch;
    }


    public static void parallel (double[][] A, double[][] B)throws InterruptedException {
        // 声明和初始化
        long startTime;
        long endTime;

        int threadNum = 2;
        //子线程的分片计算间隔
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        //存放并行计算结果
        double[][] parallel_result = new double[A.length][B[0].length];
        //子线程数量

        int gap = A.length / (threadNum-1);
        // 并行计算


        Parallel parallel1 = new Parallel(A, B, 0, gap, parallel_result, countDownLatch);
        Parallel parallel2 = new Parallel(A, B, 1, gap, parallel_result, countDownLatch);
        Parallel parallel3 = new Parallel(A, B, 2, gap, parallel_result, countDownLatch);
        Parallel parallel4 = new Parallel(A, B, 3, gap, parallel_result, countDownLatch);
        startTime = System.currentTimeMillis();
        parallel1.start();
        parallel2.start();
        parallel3.start();
        parallel4.start();
        parallel1.join();
        parallel2.join();
        parallel3.join();
        parallel4.join();
        endTime = System.currentTimeMillis();


//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B[0].length; j++) {
//                System.out.print(parallel_result[i][j]+" ");
//            }
//            System.out.println("");
//        }
        System.out.println("并行计算开始时刻:" + (startTime));
        System.out.println("并行计算结束时刻:" + (endTime));
        System.out.println("并行计算运行时间:" + (endTime - startTime));
    }
    // 计算特定范围内的结果
    public void run() {
        // TODO Auto-generated method stub
        for (int i = index * gap; i < Math.min((index + 1)*gap,A.length) ; i++)
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        // 线程数减1
        countDownLatch.countDown();
    }
}