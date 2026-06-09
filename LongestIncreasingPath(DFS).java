import java.util.*;

public class Main {

    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m]; // memoization

        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j, n, m));
            }
        }

        return max;
    }

    public static int dfs(int[][] matrix, int[][] dp, int i, int j, int n, int m) {

        if(dp[i][j] != 0) return dp[i][j];

        int maxPath = 1;

        for(int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni >= 0 && nj >= 0 && ni < n && nj < m 
               && matrix[ni][nj] > matrix[i][j]) {

                maxPath = Math.max(maxPath, 
                          1 + dfs(matrix, dp, ni, nj, n, m));
            }
        }

        dp[i][j] = maxPath;
        return maxPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(longestIncreasingPath(matrix));
    }
}