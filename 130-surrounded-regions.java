class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int r = 0;r<rows;r++){
            if(board[r][0]=='O')dfs(board, r , 0);
            if(board[r][cols-1]=='O') dfs(board, r, cols-1);
        }
        
        for(int c=0;c<cols;c++){
            if(board[0][c]=='O') dfs(board,0,c); if(board[rows-1][c]=='O')dfs(board,rows-1,c);
        }
        
        for(int r = 0;r<rows;r++){
                    for(int c=0;c<cols;c++){
                        if(board[r][c]=='O') board[r][c] = 'X';
                        if(board[r][c]=='S') board[r][c]='O';
                        
                        }
                        }
                        
    }
    
    void dfs(char[][]board,int r, int c){
        if(r<0|| r >= board.length || c<0 || c>= board[0].length) return;
    if(board[r][c]!='O') return;
            board[r][c] = 'S';
        
        int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}};
        
        for(int[]dir: dirs){
            int newR = r+dir[0];
            int newC = c + dir[1];
            
            
            dfs(board, r+dir[0],c+dir[1]);
        }
    }
}