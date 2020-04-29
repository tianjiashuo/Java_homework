import java.util.Random;

public class MatrixGenerator {
    //随机生成任意大小的矩阵，矩阵单元使用 double 存储。
    public static double[][] matrix()
    {
        Random r = new Random();
        double[][] randomMatrix = new double[r.nextInt(1000)][r.nextInt(1000)];
        for(int i=0;i<randomMatrix.length;i++)
        {
            for(int j=0;j<randomMatrix[0].length;j++)
            {
                double ran1 = r.nextDouble()*1000;
                randomMatrix[i][j] = ran1;
            }
        }
        return randomMatrix;
    }

    public static double[][] matrix(int column)
    {
        Random r = new Random();
        double[][] randomMatrix = new double[column][r.nextInt(100)];
        for(int i=0;i<randomMatrix.length;i++)
        {
            for(int j=0;j<randomMatrix[0].length;j++)
            {
                double ran1 = r.nextDouble()*1000;
                randomMatrix[i][j] = ran1;
            }
        }
        return randomMatrix;
    }


}
