package paixu;

public class FeiBoNaQi {
    public static void main(String[] args) {

        int n = 10;
        int[] a =new int[n+1];
        int result;
        a[2]=a[1]=1;
        if (n==0 || n==1)
            result=a[0];
        for(int i=3;i<=n;i++){
            a[i] = a[i-1]+a[i-2];
            System.out.println(a[i]);
        }
        int first=1;
        int second=1;
        int flag=1;
        for (int i=3;i<=n;i++){
            flag = first+second;
            first=second;
            second=flag;
        }
        System.out.println("====="+flag);
    }

}

