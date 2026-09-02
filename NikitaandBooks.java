import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long sum = 0;
            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                long x = sc.nextLong();
                sum += x;

                long need = (long) i * (i + 1) / 2;

                if (sum < need)
                    ok = false;
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
