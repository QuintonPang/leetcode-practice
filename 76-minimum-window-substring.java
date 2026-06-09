class Solution {
    public String minWindow(String s, String t) {
       if(s.length()  == 0 || t.length() == 0 || s.length() < t.length())  return "";

       Map <Character, Integer> target = new HashMap<>();

       for(int i = 0;i < t.length();i++){
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i),0)+1);

       }

       int required = target.size();

       int l = 0,  r =0;

       int match = 0;

       int[] ans = { -1 , 0 , 0};  // index 0 : 1 for found -1 for not found

       Map<Character, Integer> substringMap = new HashMap<>();

       while ( r<s.length()){
        char c = s.charAt(r);
        int count = substringMap.getOrDefault(c, 0 );
        substringMap.put(c, count+1);
        if(target.containsKey(c) && target.get(c).intValue() == substringMap.get(c).intValue()){
            match ++;
        }

        while(match == required && l <= r){ // l < = r because need to check when l = r as well 
                char c2 = s.charAt(l);
                if(ans[0]==-1 ||  ans[0] >= r-l+1){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;

                  
                }
                  substringMap.put(c2, substringMap.get(c2) -1);
                    if(target.containsKey(c2) && target.get(c2) > substringMap.get(c2)) match -- ;

                    l++;
                
        
       }

               r++;
       }
       if(ans[0] == -1) return "";

       return s.substring(ans[1],ans[2] + 1);
    
    }
}