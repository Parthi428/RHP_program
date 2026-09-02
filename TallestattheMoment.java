import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] h = new long[n];
        long[] l = new long[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextLong();
            l[i] = sc.nextLong();
        }

        ArrayList<Long> height = new ArrayList<>();
        ArrayList<Long> leave = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!height.isEmpty() &&
                   height.get(height.size() - 1) <= h[i]) {
                height.remove(height.size() - 1);
                leave.remove(leave.size() - 1);
            }

            height.add(h[i]);
            leave.add(l[i]);
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            long t = sc.nextLong();

            int low = 0;
            int high = leave.size();

            while (low < high) {
                int mid = (low + high) / 2;

                if (leave.get(mid) > t)
                    high = mid;
                else
                    low = mid + 1;
            }

            System.out.println(height.get(low));
        }
    }
}
