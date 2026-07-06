class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0 ; i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    boolean dfs(char[][]board, int r, int c, String word,int index){
        if(index== word.length())return true;
        if(r>board.length -1  || r<0 || c>board[r].length-1||c<0 || board[r][c]!=word.charAt(index)||board[r][c]=='#')return false;
        
        
    
            
            
            char ch = board[r][c];
            board[r][c] = '#';
            
            boolean result = dfs(board,r+1,c,word,index+1)
    ||    dfs(board,r-1,c,word,index+1)
        || dfs(board,r, c+1,word,index+1)||dfs(board,r,c-1,word,index+1);
        
        board[r][c] = ch;
        
        return result;
    }
}