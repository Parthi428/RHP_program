import java.util.*;

class Mex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int zeros = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] == 0)
                    zeros++;
            }

            if (zeros < 2) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");

            char[] ans = new char[n];

            int zeroCount = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    zeroCount++;

                    if (zeroCount == 1)
                        ans[i] = 'A';
                    else if (zeroCount == 2)
                        ans[i] = 'B';
                    else
                        ans[i] = 'A';
                } 
                else if (a[i] == 1) {
                    ans[i] = 'C';
                } 
                else {
                    ans[i] = 'C';
                }
            }

            System.out.println(new String(ans));
        }

        sc.close();
    }
}
