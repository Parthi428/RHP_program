
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] a = new long[n + 1];

        for (int i = 1; i <= n; i++)
            a[i] = sc.nextLong();

        while (q-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (type == 1) {
                long x = sc.nextLong();

                for (int i = l; i <= r; i++)
                    a[i] += x;
            } 
            else {
                long sum = 0;

                for (int i = l; i <= r; i++)
                    sum += a[i];

                System.out.println(sum);
            }
        }
    }
}
