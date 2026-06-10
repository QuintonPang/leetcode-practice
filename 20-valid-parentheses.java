class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>(Map.of(
            ')','(',
            '}','{',
            ']','['
        ));

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(!brackets.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                Character current = stack.pop();
                if(current!=brackets.get(c)){
                    return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
            return false;
    }
}