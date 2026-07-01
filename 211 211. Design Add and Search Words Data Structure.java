class WordDictionary {
    
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

TrieNode root;
    public WordDictionary() {
         root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index]==null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return searchHelper(word,0,curr);
    }
    
    boolean searchHelper(String word, int i, TrieNode curr){
        if(i==word.length()) return curr.isEnd;
        char c = word.charAt(i);
        if(c=='.'){
            for(TrieNode child: curr.children){
                if(child != null && searchHelper(word, i+1, child))
                
                return true;
                
                }
                
                return false;
        
        
        
    }else{
        int index = c -'a';
        if(curr.children[index]==null) return false;
        else
        return searchHelper(word,i+1,curr.children[index]);
    }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */