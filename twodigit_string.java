import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();

            int n = a.length();
            int m = b.length();

            int[] pa = new int[n + 1];
            int[] pb = new int[m + 1];

            for (int i = 0; i < n; i++)
                pa[i + 1] = (pa[i] + a.charAt(i) - '0') % 10;

            for (int i = 0; i < m; i++)
                pb[i + 1] = (pb[i] + b.charAt(i) - '0') % 10;

            if (pa[n] != pb[m]) {
                System.out.println(-1);
                continue;
            }

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {

                    if (i < n)
                        dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);

                    if (j < m)
                        dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);

                    if (i < n && j < m && pa[i] == pb[j])
                        dp[i + 1][j + 1] = Math.max(
                                dp[i + 1][j + 1], dp[i][j] + 1);
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
