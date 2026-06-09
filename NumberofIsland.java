import java.util.*;

public class Main {

    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j, int n, int m) {

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // mark visited

        for(int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], n, m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));
    }
}