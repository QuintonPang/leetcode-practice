class Trie {

TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }
    
    public class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            
            if(curr.children[c-'a']==null)curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr= root; int cIndex=0;
        for(char c:word.toCharArray()){
            int index = c -'a';
            if(curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(char c:prefix.toCharArray()){
            int index = c -'a';
            if(curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        
        return true; }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */