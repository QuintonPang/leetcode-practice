class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int changes[] = new int[s.length()+1];
        for( int i = 0;i< shifts.length;i++){
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            if(direction==1){
            changes[start] ++;
            changes[end+1] --;}
            else{
     changes[start] --;
            changes[end+1] ++;
            }
        }


        StringBuilder sb = new StringBuilder();
        int current = 0;
        for(int i = 0;i< s.length();i++){
            current+=changes[i];
            char newC  =(char) (Math.floorMod((s.charAt(i) - 'a') + current,26) +'a');
            sb.append(newC);
        }

        return sb.toString();
    }
}
