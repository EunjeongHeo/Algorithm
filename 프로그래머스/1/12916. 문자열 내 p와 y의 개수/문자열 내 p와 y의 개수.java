class Solution {
    boolean solution(String s) {
        
        int p = 0;
        int y = 0;
        
        // 전체 문자열을 소문자로 변환
        s = s.toLowerCase();
        
        // p 제거 후 p 개수 카운트 
        p = s.length() - s.replace("p","").length();
        
        // y 제거 후 y 개수 카운트 
        y = s.length() - s.replace("y","").length();
        
        
        if(p == y)
            return true;
        else
            return false;
        
    }
}