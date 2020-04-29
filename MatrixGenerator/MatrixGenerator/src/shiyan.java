
public class shiyan extends Thread{

    private long A[][];
    private long B[][];
    private long C[][];
    private int start ;
    private int end ;
    private long sum = 0 ;

    public shiyan(long a[][],long b[][],int st,int en){
        this.A = a;
        this.B = b;
        this.start = st;
        this.end = en;
        this.C = new long[en][en];
    }
    public void run(){
        int i,j,k;
        for( i=start; i< end; i += 2)
        {
            for( j=0;j<end;j++)
            {
                C [i][j] = 0;
                for( k=0; k< end;k++)
                {
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
    }

    public long getSum() {
        return this.sum;
    }
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        int i,j,t = 0;
        int leng = 1500;
        long startTime,endTime;
        long a[][] = new long[leng][leng];
        long b[][] = new long[leng][leng];
        //--------------对矩阵A和矩阵B进行初始化-------------
        for(i=0;i<leng;i++)
        {
            t=i+1;
            for(j=0;j<leng;j++)
            {
                a[i][j]=t++;
                b[i][j]=1;
            }
        }
        shiyan thread1 = new shiyan(a, b, 0, leng);
        shiyan thread2 = new shiyan(a, b, 1, leng);
        //-------------------并行计算--------------------
        startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        endTime = System.currentTimeMillis();
        System.out.println("并行结果 = " + (thread1.getSum() + thread2.getSum()));
        System.out.println("并行时间 = " + (endTime - startTime));
    }

}