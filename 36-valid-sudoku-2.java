class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int SIZE = 9;

        Set <Character>[] rows = new HashSet[SIZE];
        Set <Character>[] columns = new HashSet[SIZE];
        Set <Character>[] boxes = new HashSet[SIZE];

for(int i =0;i<SIZE;i++){
    rows[i] = new HashSet<>();
        columns[i] = new HashSet<>();

    boxes[i] = new HashSet<>();

}
        for(int r = 0; r<SIZE;r++){
            for (int c=0;c< SIZE; c++){
                char ch = board[r][c];

                if( ch == '.' ) continue;
                
                if(columns[c].contains(ch)){
                    return false;
                }else{
                    columns[c].add(ch);
                }

            if(rows[r].contains(ch)){
                    return false;
                }else{
                    rows[r].add(ch);
                }

                int boxesNo = r/3 * 3 + c/3;
                if(boxes[boxesNo].contains(ch)){
                    return false;
                }else{
                    boxes[boxesNo].add(ch);
                }
            }
                

        }
        return true;
    }
}