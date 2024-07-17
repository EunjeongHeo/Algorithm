import java.util.Scanner;
import java.util.ArrayList;


class Solution {
    public int[] solution(String S) {
                
        int count_zero = 0;
        int count_translate = 0;
        
        char[] s = S.toCharArray(); // 0 제거 전 문자열(문자리스트)
        ArrayList<Character> x = new ArrayList<>(); // 0 제거 후 문자열(문자리스트))

    
        while (!(s.length == 1 && s[0] == '1' )){ // s != 1 동안
            
            // 문자열 s (0 제거 전) -> 문자열 x (0 제거 후)
            for (char c : s) {
                if (!(c == '0'))
                    x.add(c);
                else
                    count_zero++;
            }
            s = Integer.toBinaryString(x.size()).toCharArray(); // 문자열 x 사이즈를 2진수로 변환하여 문자열 s에 저장
            x.clear(); // 문자열 x 초기화
            count_translate++;
        }
        
        int[] answer = new int[]{count_translate, count_zero};
        return answer;
    }

}