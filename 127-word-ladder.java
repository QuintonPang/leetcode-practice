class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>words = new HashSet<>(wordList);

        if(!words.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();

        q.offer(beginWord);
        Set<String>visited = new HashSet<>();
        visited.add(beginWord);

int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k =0;k<size;k++){
                String word = q.poll();
                                            if(word.equals(endWord)) return steps;

                for(int i = 0 ;i<word.length();i++){
                    StringBuilder sb = new StringBuilder(word);
                    for(int j = 0 ;j<26;j++){
                        if(sb.charAt(i) == (char)('a'+j)) continue;
                            sb.setCharAt(i, (char)('a'+j));

                            if(!visited.contains(sb.toString()) && words.contains(sb.toString())) {q.offer(sb.toString()); visited.add(sb.toString());}

                    }
                }
            }
            steps++;
        }

        return 0;
    }
}
