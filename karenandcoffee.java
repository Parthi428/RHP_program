import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[200002];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            arr[l]++;
            arr[r + 1]--;
        }

        for (int i = 1; i <= 200000; i++) {
            arr[i] += arr[i - 1];
        }

        int[] pre = new int[200001];

        for (int i = 1; i <= 200000; i++) {
            pre[i] = pre[i - 1];

            if (arr[i] >= k) {
                pre[i]++;
            }
        }

        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(pre[b] - pre[a - 1]);
        }
    }
}
