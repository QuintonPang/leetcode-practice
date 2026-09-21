class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;

        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            int value = i % 2 == 0 ? 1 : -1;

            rows[row] += value;
            cols[col] += value;

            if (row == col) {
                diagonal += value;
            }

            if (row + col == 2) {
                antiDiagonal += value;
            }

            if (Math.abs(rows[row]) == 3 ||
                Math.abs(cols[col]) == 3 ||
                Math.abs(diagonal) == 3 ||
                Math.abs(antiDiagonal) == 3) {
                return value == 1 ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
