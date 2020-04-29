import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class Serial {

    public static void serial(double[][] A, double[][] B){
        double[][] result = new double[A.length][B[0].length];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        long endTime = System.currentTimeMillis();
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B[0].length; j++) {
//                System.out.print(result[i][j]+" ");
//            }
//            System.out.println("");
//        }

        System.out.println("串行计算开始时刻:" + (startTime));
        System.out.println("串行计算结束时刻:" + (endTime));
        System.out.println("串行计算运行时间:" + (endTime - startTime));

    }


}
