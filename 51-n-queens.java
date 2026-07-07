class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        int[] cols = new int[n];

        boolean usedCols[] = new boolean[n];
        // ranges from -n+1 to n - 1
        boolean[] diag1 = new boolean[2*n-1]; // "\" constant: r-c
        boolean[] diag2 = new boolean[2*n-1]; // "/" constant: r+c
        
        backtrack(0, cols, usedCols, diag1, diag2, n, answer);

        return answer;
    }

    void backtrack(int row, int[] cols, boolean usedCols[], boolean[]diag1, boolean[]diag2, int n, List<List<String>> answer){
       
       if(row == n){
        answer.add(buildBoard(n,cols));
        return;
       }

        for(int col = 0; col< n;col++){
             int d1 = row - col + n -1; // shift to make index from 0 to 2n -1
        int d2 = row + col;
            if(usedCols[col] || diag1[d1] || diag2[d2]){
                continue; // conflict occurs
            }

            usedCols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            cols[row] = col;

            backtrack(row+1, cols, usedCols, diag1, diag2, n , answer);

                // remove queen
             usedCols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;

        }

    }

    List<String> buildBoard(int n, int [] cols){
        List<String> board = new ArrayList<>();
        for(int i = 0; i< n;i++){
            char[] rowChars= new char[n];
            Arrays.fill(rowChars, '.');
            rowChars[cols[i]] = 'Q';
            board.add(new String(rowChars));
        }

        return board;
    }
}
