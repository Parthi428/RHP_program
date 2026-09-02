import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u].add(v);
                graph[v].add(u);
            }

            int start = sc.nextInt();

            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            dist[start] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : graph[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 6;
                        q.add(v);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (i != start)
                    System.out.print(dist[i] + " ");
            }

            System.out.println();
        }
    }
}
