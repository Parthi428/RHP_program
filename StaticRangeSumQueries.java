import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] prefix = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + sc.nextLong();
        }

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(prefix[r] - prefix[l - 1]);
        }
    }
}
