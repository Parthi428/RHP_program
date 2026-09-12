import java.util.*;

public class MaximumXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qrTNum = sc.nextInt();

        while (qrTNum-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long s = x + y;
            long nx = 0;

            for (int bit = 30; bit >= 0; bit--) {
                long b = 1L << bit;

                if ((s & b) != 0 && nx + b <= x)
                    nx += b;
            }

            System.out.println(s + " " + (x - nx));
        }
    }
}
