import java.util.*;

class Treasuremap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];

            for (int i = 0; i < n; i++)
                b[i] = sc.nextInt();

            // lo[i], hi[i] = possible range of distance at i
            int[] lo = new int[n];
            int[] hi = new int[n];

            for (int i = 0; i < n; i++) {
                if (b[i] == -1) {
                    lo[i] = 0;
                    hi[i] = n;
                } else {
                    lo[i] = hi[i] = b[i];
                }
            }

            // Forward propagation
            for (int i = 1; i < n; i++) {
                lo[i] = Math.max(lo[i], lo[i - 1] - 1);
                hi[i] = Math.min(hi[i], hi[i - 1] + 1);

                if (lo[i] > hi[i])
                    break;
            }

            boolean possible = true;

            // Backward propagation
            for (int i = n - 2; i >= 0; i--) {
                lo[i] = Math.max(lo[i], lo[i + 1] - 1);
                hi[i] = Math.min(hi[i], hi[i + 1] + 1);

                if (lo[i] > hi[i]) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("-1");
                continue;
            }

            /*
             * Construct actual distance array.
             * Choose the smallest possible value.
             */
            int[] dist = new int[n];

            dist[0] = lo[0];

            for (int i = 1; i < n; i++) {
                int value = Math.max(lo[i], dist[i - 1] - 1);

                if (value > hi[i] || Math.abs(value - dist[i - 1]) > 1) {
                    possible = false;
                    break;
                }

                dist[i] = value;
            }

            if (!possible) {
                System.out.println("-1");
                continue;
            }

            /*
             * A valid distance map must have:
             * - distance 0 at treasure
             * - every positive distance must eventually
             *   decrease toward a zero.
             */
            boolean hasTreasure = false;

            for (int i = 0; i < n; i++) {
                if (dist[i] == 0)
                    hasTreasure = true;
            }

            if (!hasTreasure) {
                System.out.println("-1");
                continue;
            }

            StringBuilder treasure_map_fin = new StringBuilder();

            for (int i = 0; i < n; i++) {
                treasure_map_fin.append(dist[i] == 0 ? '1' : '0');
            }

            System.out.println(treasure_map_fin);
        }

        sc.close();
    }
}
