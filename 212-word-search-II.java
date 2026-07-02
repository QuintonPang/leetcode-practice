class Solution {


    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words){
                    TrieNode current = root;

            for(char c: word.toCharArray()){
                int index = c- 'a';
                if(current.children[index]==null) current.children[index] = new TrieNode();
                current = current.children[index];
            }
            current.word = word;
        }

        List<String> result = new ArrayList<>();
        
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c<board[r].length;c++){
                dfs(r,c, board, root, result);
            }
        }

        return result;
    }

    void dfs(int r, int c, char[][]board, TrieNode node, List<String> result){
        // base case 1: out of range
        if(r<0 || r>=board.length || c<0 || c>=board[r].length) return;
        char ch = board[r][c];

        // base case 2: already used
        if (ch == '#') return;

        // base case 3: not found
        if(node.children[ch-'a'] == null) return;

        TrieNode next = node.children[ch-'a'];
        if(next.word != null){
            result.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';
        dfs(r+1, c, board, next, result);
                dfs(r-1, c, board, next, result);
        dfs(r, c+1, board, next, result);
        dfs(r, c-1, board, next, result);

        // restore cell so the others can use it
        board[r][c] = ch;

        if(next.word == null && isLeaf(next)){
            next.word = null;
        }
    }

    boolean isLeaf(TrieNode node){
        for(TrieNode child: node.children){
            if(child!=null) return false;
        }

        return true;
    }

}
