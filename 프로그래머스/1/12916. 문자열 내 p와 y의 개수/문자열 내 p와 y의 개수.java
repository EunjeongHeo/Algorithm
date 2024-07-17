class Solution {
    boolean solution(String s) {
        
        int p = 0;
        int y = 0;
        
        
        // p 제거 후 p 개수 카운트 
        int origin = s.length();
        s = s.replace("p","");
        s = s.replace("P","");
        p = origin - s.length();
        
        // y 제거 후 y 개수 카운트 
        origin = s.length();
        s = s.replace("y","");
        s = s.replace("Y","");
        y = origin - s.length();
        
        
        if(p == y)
            return true;
        else
            return false;
        
    }
}