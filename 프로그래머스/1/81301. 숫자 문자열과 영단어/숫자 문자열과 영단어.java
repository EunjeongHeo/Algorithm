class Solution {
    public int solution(String s) {
        String[] mapArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < mapArr.length; i++){
            s = s.replace(mapArr[i],Integer.toString(i));
        }
        
        int answer = Integer.valueOf(s);
        
        
        return answer;
        
    }
}