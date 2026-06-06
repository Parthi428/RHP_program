public class Main {

    public static void main(String[] args) {

        int[][] grid = {
            {10, 20, 30,40},
            {10, 5,5, 6},
            {2,3, 4, 8},
            {10,20,40,100}
        };

        int R = grid.length;
        int C = grid[0].length;

        int[][] dp = new int[R][C];

        for (int row = 0; row < R; row++) {
            dp[row][0] = grid[row][0];
        }

        for (int col = 1; col < C; col++) {

            int[] maxVals = getMaxAndSecondMaxColumn(dp, col - 1, R);
            int max = maxVals[0];
            int secondMax = maxVals[1];

            for (int row = 0; row < R; row++) {

                if (dp[row][col - 1] == max) {
                    dp[row][col] = grid[row][col] + secondMax;
                } else {
                    dp[row][col] = grid[row][col] + max;
                }
            }
        }

        System.out.println("DP Matrix:");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int result = getMaxAndSecondMaxColumn(dp, C - 1, R)[0];
        System.out.println("Final Answer = " + result);
    }

    
    public static int[] getMaxAndSecondMaxColumn(int[][] dp, int col, int R) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int row = 0; row < R; row++) {
            if (dp[row][col] > max) {
                secondMax = max;
                max = dp[row][col];
            } else if (dp[row][col] > secondMax) {
                secondMax = dp[row][col];
            }
        }

        return new int[]{max, secondMax};
    }
}