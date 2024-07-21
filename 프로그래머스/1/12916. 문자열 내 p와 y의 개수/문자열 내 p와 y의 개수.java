class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int p_count = s.length();
        
        s = s.replace("p","");
        
        p_count -= s.length();
        
        int y_count = s.length();
        s = s.replace("y","");
        y_count -= s.length();
        
        if (p_count == y_count)
            return true;
        else
            return false;
        
    }
}