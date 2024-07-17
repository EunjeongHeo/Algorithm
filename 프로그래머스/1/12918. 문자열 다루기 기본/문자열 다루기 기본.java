class Solution {
    public boolean solution(String s) {
        
        char[] charArr = s.toCharArray();

        // 문자열 길이 체크
        if (charArr.length != 4 && charArr.length != 6){
            return false;
        }
        
        // 숫자 체크
        for (char c : charArr){
            if(!(c >= '0' && c <= '9'))
                return false;
        }
        
        return true;
        
    }
}