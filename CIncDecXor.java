import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();

            long inc = Math.abs(a - x);
            long dec = Math.abs(a + x);
            long xor = a ^ x;

            ans += Math.min(inc, Math.min(dec, xor));
        }

        System.out.println(ans);
    }
}
