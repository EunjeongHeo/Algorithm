class Solution {
    public int[] solution(String s) {
        
        int zero_count = 0;
        int translate_count = 0;
        
        while(!s.equals("1")){
            int before = s.length();
            s = s.replace("0","");
            int after = s.length();
            zero_count += before - after;
            s = Integer.toBinaryString(s.length());
            translate_count++;
        }
        int[] answer = {translate_count, zero_count};
        
        
        return answer;
    }
}