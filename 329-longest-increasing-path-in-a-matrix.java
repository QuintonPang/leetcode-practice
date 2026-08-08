class Solution {

     int [][] dirs = {
                {1,0},
                {0, 1},
                { -1, 0},
                {0, -1}
        }  ;
    public int longestIncreasingPath(int[][] matrix) {
       

        int rows = matrix.length;
        int cols = matrix[0].length;

        int answer = 0;

        int[][] dp = new int[rows][cols];

        for(int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                answer = Math.max(answer, dfs( i , j, dp, matrix));
            }
        }
    return answer;

    }

    int dfs(int row, int col , int[][]dp, int[][]matrix){
        if(dp[row][col]!= 0) return dp[row][col]; //visited

        int longest = 1;

        for(int[] dir: dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[row][col]){
                longest = Math.max(longest, 1 + dfs(newRow, newCol, dp, matrix));
            }
        }

        dp[row][col] = longest;

        return longest;
    }

}
